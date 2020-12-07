package com.switchfully.youcoach.user_management;

import com.switchfully.youcoach.user_management.user_domain.Email;
import com.switchfully.youcoach.user_management.user_domain.User;
import com.switchfully.youcoach.user_management.user_dto.CreateUserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User convertCreateUserDtoToUser(CreateUserDTO createUserDTO) {
        return new User(createUserDTO.getFirstName(), createUserDTO.getLastName(), new Email(createUserDTO.getEmail()));
    }
}
