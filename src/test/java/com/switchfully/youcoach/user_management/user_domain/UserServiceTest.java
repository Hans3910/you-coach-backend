package com.switchfully.youcoach.user_management.user_domain;

import com.switchfully.youcoach.user_management.user_domain.entity.Email;
import com.switchfully.youcoach.user_management.user_domain.entity.User;
import com.switchfully.youcoach.user_management.user_domain.repository.CoacheeRepository;
import com.switchfully.youcoach.user_management.user_domain.repository.UserRepository;
import com.switchfully.youcoach.user_management.user_exceptions.UsedEmailException;
import com.switchfully.youcoach.user_management.user_exceptions.UserNotFoundException;
import com.switchfully.youcoach.user_management.user_service.UserService;
import com.switchfully.youcoach.user_management.user_service.user_dto.CreateUserDTO;
import com.switchfully.youcoach.user_management.user_service.user_dto.GetUserDTO;
import com.switchfully.youcoach.user_management.user_service.user_mapper.CoacheeMapper;
import com.switchfully.youcoach.user_management.user_service.user_mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.UUID;

class UserServiceTest {

    private UserRepository userRepository;
    private UserMapper userMapper;
    private UserService userService;
    private CoacheeRepository coacheeRepository;
    private CoacheeMapper coacheeMapper;

    @BeforeEach
    public void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        userMapper = Mockito.mock(UserMapper.class);
        coacheeRepository = Mockito.mock(CoacheeRepository.class);
        coacheeMapper = Mockito.mock(CoacheeMapper.class);
        userService = new UserService(userRepository, userMapper, coacheeRepository, coacheeMapper);
    }

    @Test
    void givenNewUser_ItWillBeRegisteredIfEmailIsDistinct() {
        User user1 = new User("John", "Doe", new Email("john_doe@hotmail.com"), "pictureUrl");
        CreateUserDTO createUserDTO1 = new CreateUserDTO("John", "Doe", "john_doe@hotmail.com", "pictureUrl");
        Mockito.when(userMapper.convertCreateUserDtoToUser(createUserDTO1)).thenReturn(user1);
        userService.registerUser(createUserDTO1);
        Mockito.verify(userRepository).save(user1);
    }

    @Test
    void givenNewUser_IfEmailIsAlreadyUsed_UsedEmailExceptionIsThrown() {
        User user1 = new User("John", "Doe", new Email("john_doe@hotmail.com"), "pictureUrl");
        Mockito.when(userRepository.existsDistinctByEmail(user1.getEmail())).thenReturn(true);
        Assertions.assertThrows(UsedEmailException.class, () -> userService.isEmailUnique(user1.getEmail()));
    }

    @Test
    void givenEmail_IfUserExists_ThenIGetAUserDto() {
        User user1 = new User("John", "Doe", new Email("john_doe@hotmail.com"), "pictureUrl");

        GetUserDTO getUserDTO = new GetUserDTO();
        getUserDTO.setFirstName(user1.getFirstName());
        getUserDTO.setLastName(user1.getLastName());
        getUserDTO.setEmail("john_doe@hotmail.com");
        Optional<User> userOptional = Optional.of(user1);
        Mockito.when(userRepository.findByEmail(new Email("john_doe@hotmail.com"))).thenReturn(userOptional);
        Mockito.when(userMapper.convertUserToGetUserDTO(user1)).thenReturn(getUserDTO);
        userService.signIn("john_doe@hotmail.com");
        Mockito.verify(userRepository).findByEmail(user1.getEmail());
        Mockito.verify(userMapper).convertUserToGetUserDTO(user1);
    }

    @Test
    void givenEmail_IfUserDoesNotExist_ThenAUserNotFoundExceptionIsThrown() {
        User user1 = new User("John", "Doe", new Email("john_doe@hotmail.com"), "pictureUrl");
        Optional<User> userOptional = Optional.of(user1);
        Mockito.when(userRepository.findByEmail(new Email("john_doe@hotmail.com"))).thenReturn(userOptional);
        Assertions.assertThrows(UserNotFoundException.class,()-> userService.signIn("wrongemail@hotmail.com"));
    }

    @Test
    void givenId_IfUserExists_ThenIGetAUserDto() {
        User user1 = new User("John", "Doe", new Email("john_doe@hotmail.com"), "pictureUrl");
        GetUserDTO getUserDTO = new GetUserDTO();
        getUserDTO.setFirstName(user1.getFirstName());
        getUserDTO.setLastName(user1.getLastName());
        getUserDTO.setEmail("john_doe@hotmail.com");
        UUID uuidToCheck = UUID.randomUUID();
        Mockito.when(userRepository.findById(uuidToCheck)).thenReturn(Optional.of(user1));
        Mockito.when(coacheeMapper.convertCoacheeToGetCoacheeDTO(user1.getCoachee())).thenReturn(getUserDTO.getGetCoacheeDTO());
        Mockito.when(userMapper.convertUserToGetUserDTO(user1)).thenReturn(getUserDTO);
        userService.getUserById(uuidToCheck.toString());
        Mockito.verify(userRepository).findById(uuidToCheck);
        Mockito.verify(coacheeMapper).convertCoacheeToGetCoacheeDTO(user1.getCoachee());
    }

    @Test
    void givenId_IfUserDoesNotExist_ThenAUserDoesNotExceptionIsThrown() {
        UUID uuidToCheck = UUID.randomUUID();
        Assertions.assertThrows(UserNotFoundException.class,()->userService.getUserById(uuidToCheck.toString()));
    }
}
