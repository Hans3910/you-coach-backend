package com.switchfully.youcoach.user_management.user_service;


import com.switchfully.youcoach.user_management.user_domain.entity.Email;
import com.switchfully.youcoach.user_management.user_domain.entity.User;
import com.switchfully.youcoach.user_management.user_domain.repository.UserRepository;
import com.switchfully.youcoach.user_management.user_exceptions.UsedEmailException;
import com.switchfully.youcoach.user_management.user_exceptions.UserNotFoundException;
import com.switchfully.youcoach.user_management.user_service.user_dto.CreateUserDTO;
import com.switchfully.youcoach.user_management.user_service.user_dto.GetUserDTO;
import com.switchfully.youcoach.user_management.user_service.user_mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    public GetUserDTO signIn(String email) {
        Email emailToCheck = new Email(email);
        Optional<User> optionalUser = userRepository.findByEmail(emailToCheck);

        if(optionalUser.isEmpty()) throw new UserNotFoundException("User with " + email + " does not exist in the application");

        return userMapper.convertUserToGetUserDTO(optionalUser.get());
    }

    public List<GetUserDTO> getAllUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(user -> userMapper.convertUserToGetUserDTO(user))
                .collect(Collectors.toList());
    }
}
