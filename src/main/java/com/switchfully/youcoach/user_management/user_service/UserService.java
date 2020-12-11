package com.switchfully.youcoach.user_management.user_service;


import com.switchfully.youcoach.user_management.user_domain.entity.Email;
import com.switchfully.youcoach.user_management.user_domain.entity.User;
import com.switchfully.youcoach.user_management.user_domain.repository.CoacheeRepository;
import com.switchfully.youcoach.user_management.user_domain.repository.UserRepository;
import com.switchfully.youcoach.exceptions.UsedEmailException;
import com.switchfully.youcoach.exceptions.UserNotFoundException;
import com.switchfully.youcoach.user_management.user_service.user_dto.CreateUserDTO;
import com.switchfully.youcoach.user_management.user_service.user_dto.GetCoacheeDTO;
import com.switchfully.youcoach.user_management.user_service.user_dto.GetUserDTO;
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

    public GetUserDTO registerUser(CreateUserDTO createUserDTO) {
        User user = userMapper.convertCreateUserDtoToUser(createUserDTO);
        isEmailUnique(user.getEmail());
        coacheeRepository.save(user.getCoachee());
        GetUserDTO result = userMapper.convertUserToGetUserDTO(userRepository.save(user));
        System.out.println(result);
        result.setGetCoacheeDTO(coacheeMapper.convertCoacheeToGetCoacheeDTO(user.getCoachee()));
        return result;
    }

    public void isEmailUnique(Email email) {
        if (userRepository.existsDistinctByEmail(email)) {
            throw new UsedEmailException("There is already an account with this email");
        }
    }

    public GetUserDTO signIn(String email) {
        Email emailToCheck = new Email(email);
        Optional<User> optionalUser = userRepository.findByEmail(emailToCheck);

        if (optionalUser.isEmpty())
            throw new UserNotFoundException("User with email " + email + " does not exist in the application");

        return userMapper.convertUserToGetUserDTO(optionalUser.get());
    }

    public List<GetUserDTO> getAllUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(user -> userMapper.convertUserToGetUserDTO(user))
                .collect(Collectors.toList());
    }

    public GetUserDTO getUserById(String id) {
        Optional<User> user = userRepository.findById(UUID.fromString(id));
        if (user.isEmpty()) {
            throw new UserNotFoundException("This user does not exist.");
        } else {
            GetUserDTO getUserDTO = userMapper.convertUserToGetUserDTO(user.get());
            getUserDTO.setGetCoacheeDTO(coacheeMapper.convertCoacheeToGetCoacheeDTO(user.get().getCoachee()));
            return getUserDTO;
        }
    }

    public GetUserDTO editUser(String id, GetUserDTO getUserDTO) {
        Optional<User> user = userRepository.findById(UUID.fromString(id));
        if (user.isEmpty()) {
            throw new UserNotFoundException("This user does not exist.");
        } else {
            User userToEdit = user.get();
            userToEdit.setFirstName(getUserDTO.getFirstName());
            userToEdit.setLastName(getUserDTO.getLastName());
            userToEdit.setEmail(new Email(getUserDTO.getEmail()));
            userToEdit.setPictureUrl(getUserDTO.getPictureUrl());
            GetCoacheeDTO getCoacheeDTO = coacheeMapper.convertCoacheeToGetCoacheeDTO(userToEdit.getCoachee());
            GetUserDTO result = userMapper.convertUserToGetUserDTO(userToEdit);
            result.setGetCoacheeDTO(getCoacheeDTO);
            return result;
        }
    }
}
