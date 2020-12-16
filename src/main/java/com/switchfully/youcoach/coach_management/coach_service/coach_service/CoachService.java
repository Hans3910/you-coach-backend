package com.switchfully.youcoach.coach_management.coach_service.coach_service;

import com.switchfully.youcoach.coach_management.coach_domain.entity.Topic;
import com.switchfully.youcoach.coach_management.coach_domain.entity.TopicName;
import com.switchfully.youcoach.coach_management.coach_domain.repository.TopicNameRepository;
import com.switchfully.youcoach.coach_management.coach_domain.repository.TopicRepository;
import com.switchfully.youcoach.coach_management.coach_service.coach_dto.GetCoachDto;
import com.switchfully.youcoach.coach_management.coach_service.coach_dto.GetTopicDto;
import com.switchfully.youcoach.coach_management.coach_service.coach_mapper.CoachMapper;
import com.switchfully.youcoach.exceptions.UserNotFoundException;
import com.switchfully.youcoach.user_management.user_domain.entity.User;
import com.switchfully.youcoach.user_management.user_domain.repository.CoachRepository;
import com.switchfully.youcoach.user_management.user_domain.repository.UserRepository;
import com.switchfully.youcoach.user_management.user_service.UserService;
import com.switchfully.youcoach.user_management.user_service.user_mapper.UserMapper;

import org.checkerframework.checker.nullness.Opt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class CoachService {
    private UserRepository userRepository;
    private UserMapper userMapper;
    private CoachMapper coachMapper;
    private TopicNameRepository topicNameRepository;
    private TopicRepository topicRepository;

    @Autowired
    public CoachService(UserRepository userRepository, UserMapper userMapper, CoachMapper coachMapper,
                        TopicNameRepository topicNameRepository, TopicRepository topicRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.coachMapper = coachMapper;
        this.topicNameRepository = topicNameRepository;
        this.topicRepository = topicRepository;
    }

    public GetCoachDto getCoachById(String coachId) {
        Optional<User> user = userRepository.findByCoach_Id(UUID.fromString(coachId));
        if (user.isEmpty()) {
            throw new UserNotFoundException("User does not exist");
        }
        return coachMapper.convertCoachToGetCoachDto(user.get().getCoach(), userMapper.convertUserToGetUserDTO(user.get()));
    }

    public GetCoachDto editCoach(String coachId, GetCoachDto getCoachDto) {
        Optional<User> optionalUser = userRepository.findByCoach_Id(UUID.fromString(coachId));

        if (optionalUser.isEmpty()) throw new UserNotFoundException("User does not exist");
        User user = optionalUser.get();


        if (user.getCoach().getTopicOne() != null || !getCoachDto.getTopicOne().getName().equals("")) {
            if (user.getCoach().getTopicOne() != null && !getCoachDto.getTopicTwo().getName().equals("")) {
                updateTopic(user.getCoach().getTopicOne(), getCoachDto.getTopicOne());
            } else if (user.getCoach().getTopicOne() == null && !getCoachDto.getTopicOne().getName().equals("")) {
                user.getCoach().setTopicOne(updateTopic(new Topic(), getCoachDto.getTopicOne()));
            } else if (user.getCoach().getTopicOne() != null && getCoachDto.getTopicOne().getName().equals("")) {
                user.getCoach().setTopicOne(null);
            }

        }

        if (user.getCoach().getTopicTwo() != null || !getCoachDto.getTopicTwo().getName().equals("")) {
            if (user.getCoach().getTopicTwo() != null && !getCoachDto.getTopicTwo().getName().equals("")) {
                updateTopic(user.getCoach().getTopicTwo(), getCoachDto.getTopicTwo());
            } else if (user.getCoach().getTopicTwo() == null && !getCoachDto.getTopicTwo().getName().equals("")) {
                user.getCoach().setTopicTwo(updateTopic(new Topic(), getCoachDto.getTopicTwo()));
            } else if (user.getCoach().getTopicTwo() != null && getCoachDto.getTopicTwo().getName().equals("")) {
                user.getCoach().setTopicTwo(null);
            }

        }

        user.getCoach().setIntroduction(getCoachDto.getIntroduction());
        user.getCoach().setAvailability(getCoachDto.getAvailability());


        return coachMapper.convertCoachToGetCoachDto(user.getCoach(), userMapper.convertUserToGetUserDTO(user));
    }

   public Topic updateTopic(Topic topic, GetTopicDto topicDto) {
        Optional<TopicName> topicName = topicNameRepository.findById(topicDto.getName());

        if (topicName.isEmpty()) {
            topic.setTopicName(topicNameRepository.save(new TopicName(topicDto.getName())));
        } else {
            topic.setTopicName(topicName.get());
        }

        topic.setFirstGrade(topicDto.isFirstGrade());
        topic.setSecondGrade(topicDto.isSecondGrade());
        topic.setThirdGrade(topicDto.isThirdGrade());
        topic.setFourthGrade(topicDto.isFourthGrade());
        topic.setFifthGrade(topicDto.isFifthGrade());
        topic.setSixthGrade(topicDto.isSixthGrade());
        topic.setSeventhGrade(topicDto.isSeventhGrade());
        return topicRepository.save(topic);
    }
}
