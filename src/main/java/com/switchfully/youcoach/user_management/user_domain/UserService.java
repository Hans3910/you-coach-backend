package com.switchfully.youcoach.user_management.user_domain;

import com.switchfully.youcoach.user_management.UserMapper;
import com.switchfully.youcoach.user_management.user_dto.CreateUserDTO;
import com.switchfully.youcoach.user_management.user_exceptions.UsedEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public void registerUser(CreateUserDTO createUserDTO) {
        User user = userMapper.convertCreateUserDtoToUser(createUserDTO);
        isEmailUnique(user.getEmail());
        userRepository.save(user);
    }

    public void isEmailUnique(Email email) {
        if (userRepository.existsDistinctByEmail(email)) {
            throw new UsedEmailException("There is already an account with this email");
        }

    }
}
