package com.switchfully.youcoach.coach_management.coach_service.coach_service;

import com.switchfully.youcoach.coach_management.coach_service.coach_dto.GetCoachDto;
import com.switchfully.youcoach.user_management.user_domain.entity.User;
import com.switchfully.youcoach.user_management.user_domain.repository.UserRepository;
import com.switchfully.youcoach.user_management.user_service.UserService;
import com.switchfully.youcoach.user_management.user_service.user_mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class CoachService {
    private UserService userService;
    private UserRepository userRepository;
    private UserMapper userMapper;
    private CoachMapper coachMapper;
    @Autowired
    public CoachService(UserService userService, UserRepository userRepository, UserMapper userMapper, CoachMapper coachMapper) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.coachMapper = coachMapper;
    }

    public GetCoachDto getCoachById(String coachId){
        Optional<User> user = userRepository.findByCoach_Id(UUID.fromString(coachId));
        return coachMapper.convertCoachToGetCoachDto(userMapper.convertUserToGetUserDTO(user.get()));
    }
}
