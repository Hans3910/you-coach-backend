package com.switchfully.youcoach.user_management.user_service.user_mapper;

import com.switchfully.youcoach.user_management.user_domain.entity.Email;
import com.switchfully.youcoach.user_management.user_domain.entity.User;
import com.switchfully.youcoach.user_management.user_service.user_dto.CreateUserDTO;
import com.switchfully.youcoach.user_management.user_service.user_dto.GetUserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User convertCreateUserDtoToUser(CreateUserDTO createUserDTO) {
        return new User(createUserDTO.getFirstName(), createUserDTO.getLastName(), new Email(createUserDTO.getEmail()), createUserDTO.getPictureUrl());
    }

    public GetUserDTO convertUserToGetUserDTO(User user) {
        GetUserDTO getUserDTO = new GetUserDTO();

        getUserDTO.setId(user.getId().toString());
        getUserDTO.setFirstName(user.getFirstName());
        getUserDTO.setLastName(user.getLastName());
        getUserDTO.setEmail(user.getEmail().getEmail());
        getUserDTO.setPictureUrl(user.getPictureUrl());
        return getUserDTO;
    }
}
