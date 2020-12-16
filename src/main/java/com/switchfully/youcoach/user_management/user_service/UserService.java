package com.switchfully.youcoach.user_management.user_service;


import com.switchfully.youcoach.user_management.user_domain.entity.Email;
import com.switchfully.youcoach.user_management.user_domain.entity.User;
import com.switchfully.youcoach.user_management.user_domain.repository.CoacheeRepository;
import com.switchfully.youcoach.user_management.user_domain.repository.UserRepository;
import com.switchfully.youcoach.exceptions.UsedEmailException;
import com.switchfully.youcoach.exceptions.UserNotFoundException;
import com.switchfully.youcoach.user_management.user_service.user_dto.CreateUserDto;
import com.switchfully.youcoach.user_management.user_service.user_dto.GetCoacheeDto;
import com.switchfully.youcoach.user_management.user_service.user_dto.GetUserDto;
import com.switchfully.youcoach.user_management.user_service.user_mapper.CoacheeMapper;
import com.switchfully.youcoach.user_management.user_service.user_mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class UserService {
    private UserRepository userRepository;
    private UserMapper userMapper;
    private CoacheeRepository coacheeRepository;
    private CoacheeMapper coacheeMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, CoacheeRepository coacheeRepository, CoacheeMapper coacheeMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.coacheeRepository = coacheeRepository;
        this.coacheeMapper = coacheeMapper;
    }

    public GetCoacheeDto registerUser(CreateUserDto createUserDTO) {
        User user = userMapper.convertCreateUserDtoToUser(createUserDTO);
        isEmailUnique(user.getEmail());
        coacheeRepository.save(user.getCoachee());
        User result = userRepository.save(user);
        return coacheeMapper.convertCoacheeToGetCoacheeDTO(user.getCoachee(), userMapper.convertUserToGetUserDTO(result));
    }

    public void isEmailUnique(Email email) {
        if (userRepository.existsDistinctByEmail(email)) {
            throw new UsedEmailException("There is already an account with this email");
        }
    }

    public GetCoacheeDto signIn(String email) {
        Email emailToCheck = new Email(email);
        Optional<User> optionalUser = userRepository.findByEmail(emailToCheck);
        if (optionalUser.isEmpty())
            throw new UserNotFoundException("User with email " + email + " does not exist in the application");
        return coacheeMapper.convertCoacheeToGetCoacheeDTO(optionalUser.get().getCoachee(),userMapper.convertUserToGetUserDTO(optionalUser.get()));
    }

    public List<GetUserDto> getAllUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(user -> userMapper.convertUserToGetUserDTO(user))
                .collect(Collectors.toList());
    }

    public GetCoacheeDto getUserById(String id) {
        Optional<User> optionalUser = userRepository.findById(UUID.fromString(id));
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("This user does not exist.");
        } else {
            return coacheeMapper.convertCoacheeToGetCoacheeDTO(optionalUser.get().getCoachee(),userMapper.convertUserToGetUserDTO(optionalUser.get()));
        }
    }

    public GetCoacheeDto editUser(String id, GetUserDto getUserDTO) {
        Optional<User> user = userRepository.findById(UUID.fromString(id));
        if (user.isEmpty()) {
            throw new UserNotFoundException("This user does not exist.");
        } else {
            User userToEdit = user.get();
            userToEdit.setFirstName(getUserDTO.getFirstName());
            userToEdit.setLastName(getUserDTO.getLastName());
            userToEdit.setEmail(new Email(getUserDTO.getEmail()));
            userToEdit.setPictureUrl(getUserDTO.getPictureUrl());
            return coacheeMapper.convertCoacheeToGetCoacheeDTO(userToEdit.getCoachee(),userMapper.convertUserToGetUserDTO(userToEdit));
        }
    }
}
