package com.switchfully.youcoach.coach_management.coach_service.coach_service;

import com.switchfully.youcoach.coach_management.coach_domain.entity.Coach;
import com.switchfully.youcoach.coach_management.coach_domain.entity.Topic;
import com.switchfully.youcoach.coach_management.coach_domain.repository.TopicNameRepository;
import com.switchfully.youcoach.coach_management.coach_domain.repository.TopicRepository;
import com.switchfully.youcoach.coach_management.coach_service.coach_dto.GetCoachDto;
import com.switchfully.youcoach.coach_management.coach_service.coach_dto.GetTopicDto;
import com.switchfully.youcoach.coach_management.coach_service.coach_mapper.CoachMapper;
import com.switchfully.youcoach.exceptions.UserNotFoundException;
import com.switchfully.youcoach.user_management.user_domain.entity.Email;
import com.switchfully.youcoach.user_management.user_domain.entity.User;
import com.switchfully.youcoach.user_management.user_domain.repository.UserRepository;
import com.switchfully.youcoach.user_management.user_service.user_dto.GetUserDTO;
import com.switchfully.youcoach.user_management.user_service.user_mapper.UserMapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CoachServiceTest {
    private UserRepository userRepository;
    private UserMapper userMapper;
    private CoachMapper coachMapper;
    private TopicNameRepository topicNameRepository;
    private TopicRepository topicRepository;
    private CoachService coachService;
    private Topic topic1;
    private Topic topic2;
    private GetTopicDto getTopicDto1;
    private GetTopicDto getTopicDto2;

    @BeforeEach
    void setup() {
        userRepository = Mockito.mock(UserRepository.class);
        userMapper = Mockito.mock(UserMapper.class);
        coachMapper = Mockito.mock(CoachMapper.class);
        topicNameRepository = Mockito.mock(TopicNameRepository.class);
        topicRepository = Mockito.mock(TopicRepository.class);
        coachService = new CoachService(userRepository, userMapper, coachMapper, topicNameRepository, topicRepository);
        topic1 = Mockito.mock(Topic.class);
        topic2 = Mockito.mock(Topic.class);
        getTopicDto1 = Mockito.mock(GetTopicDto.class);
        getTopicDto2 = Mockito.mock(GetTopicDto.class);

    }

    @Test
    void whenGivenId_GetTheRightCoach() {
        User user = new User("John", "Doe", new Email("john_doe@hotmail.com"));
        GetUserDTO getUserDTO = Mockito.mock(GetUserDTO.class);
        Coach coach = new Coach(2, "intro", "available", topic1, topic2);
        GetCoachDto getCoachDto = Mockito.mock(GetCoachDto.class);
        UUID newId = UUID.randomUUID();
        user.setCoach(coach);
        Mockito.when(userRepository.findByCoach_Id(newId)).thenReturn(Optional.of(user));
        Mockito.when(userMapper.convertUserToGetUserDTO(user)).thenReturn(getUserDTO);
        Mockito.when(coachMapper.convertCoachToGetCoachDto(user.getCoach(), getUserDTO)).thenReturn(getCoachDto);
        Assertions.assertNotNull(coachService.getCoachById(newId.toString()));
        Mockito.verify(userRepository).findByCoach_Id(newId);
    }

    @Test
    void whenGivenWrongId_GetTheRightCoach() {
        UUID newId = UUID.randomUUID();
        Mockito.when(userRepository.findByCoach_Id(newId)).thenReturn(Optional.empty());
        Assertions.assertThrows(UserNotFoundException.class, () -> coachService.getCoachById(newId.toString()));
    }

//    @Test
//    void whenAdjustingTwoTopics_ChangeTopics() {
//        UUID newId = UUID.randomUUID();
//        User user = new User("John", "Doe", new Email("john_doe@hotmail.com"));
//        Coach coach = new Coach(2, "intro", "available", topic1, topic2);
//        GetCoachDto getCoachDto = new GetCoachDto();
//        getCoachDto.setTopicOne(getTopicDto1);
//        getCoachDto.setTopicTwo(getTopicDto2);
////        Mockito.when(getCoachDto.getTopicOne().getName()).thenReturn("topic1");
////        Mockito.when(getCoachDto.getTopicTwo().getName()).thenReturn("topic2");
//        GetUserDTO getUserDTO = Mockito.mock(GetUserDTO.class);
//        user.setCoach(coach);
//        Mockito.when(userRepository.findByCoach_Id(newId)).thenReturn(Optional.of(user));
//        coachService.editCoach(newId.toString(),getCoachDto);
////        Mockito.verify(coachService,Mockito.times(1)).updateTopic(topic1,getTopicDto1);
//
//    }


}
