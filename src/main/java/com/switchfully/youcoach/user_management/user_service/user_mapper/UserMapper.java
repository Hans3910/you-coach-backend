package com.switchfully.youcoach.user_management.user_service.user_mapper;

import com.switchfully.youcoach.user_management.user_domain.entity.Email;
import com.switchfully.youcoach.user_management.user_domain.entity.User;
import com.switchfully.youcoach.user_management.user_service.user_dto.CreateUserDto;
import com.switchfully.youcoach.user_management.user_service.user_dto.GetCoacheeDto;
import com.switchfully.youcoach.user_management.user_service.user_dto.GetUserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public User convertCreateUserDtoToUser(CreateUserDto createUserDTO) {
        return new User(createUserDTO.getFirstName(), createUserDTO.getLastName(), new Email(createUserDTO.getEmail()));
    }

    public GetUserDto convertUserToGetUserDTO(User user) {
        GetUserDto getUserDTO = new GetUserDto();

        getUserDTO.setUserId(user.getId().toString());
        getUserDTO.setFirstName(user.getFirstName());
        getUserDTO.setLastName(user.getLastName());
        getUserDTO.setEmail(user.getEmail().getEmail());
        getUserDTO.setPictureUrl(user.getPictureUrl());
        return getUserDTO;
    }


}
