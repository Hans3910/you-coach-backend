package com.switchfully.youcoach.coach_management.coach_service.coach_service;

import com.switchfully.youcoach.user_management.user_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CoachService {
    private UserService userService;
    @Autowired
    public CoachService(UserService userService) {
        this.userService = userService;
    }

//    public GetUserDTO getCoachById(String userId) {
//        GetUserDTO getUserDTO = userService.getUserById(userId);
//        if (user.isEmpty()) {
//            throw new UserNotFoundException("This user does not exist.");
//        } else {
//            GetUserDTO getUserDTO = userMapper.convertUserToGetUserDTO(user.get());
//            getUserDTO.setGetCoacheeDTO(coacheeMapper.convertCoacheeToGetCoacheeDTO(user.get().getCoachee()));
//            return getUserDTO;
//        }
//    }

}
