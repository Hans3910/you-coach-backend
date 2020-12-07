package com.switchfully.youcoach.user_management.user_domain;

import com.switchfully.youcoach.user_management.UserMapper;
import com.switchfully.youcoach.user_management.user_dto.CreateUserDTO;
import com.switchfully.youcoach.user_management.user_exceptions.UsedEmailException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserRepository userRepository;
    private UserMapper userMapper;
    private UserService userService;

    @BeforeEach
    public void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        userMapper = Mockito.mock(UserMapper.class);
        userService = new UserService(userRepository, userMapper);
    }

    @Test
    void givenNewUser_ItWillBeRegisteredIfEmailIsDistinct() {
        User user1 = new User("John", "Doe", new Email("john_doe@hotmail.com"));
        CreateUserDTO createUserDTO1 = new CreateUserDTO("John", "Doe", "john_doe@hotmail.com");
        Mockito.when(userMapper.convertCreateUserDtoToUser(createUserDTO1)).thenReturn(user1);
        userService.registerUser(createUserDTO1);
        Mockito.verify(userRepository).save(user1);
    }

    @Test
    void givenNewUser_IfEmailIsAlreadyUsed_UsedEmailExceptionIsThrown() {
        User user1 = new User("John", "Doe", new Email("john_doe@hotmail.com"));
        Mockito.when(userRepository.existsDistinctByEmail(user1.getEmail())).thenReturn(true);
        Assertions.assertThrows(UsedEmailException.class, () -> userService.isEmailUnique(user1.getEmail()));
    }
}
