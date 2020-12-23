package com.switchfully.youcoach.user_management.user_domain.repository;

import com.switchfully.youcoach.user_management.user_domain.entity.Email;
import com.switchfully.youcoach.user_management.user_domain.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.util.Assert;

import java.util.Optional;
import java.util.UUID;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    @Sql("users.sql")
    public void givenCorrectUserEmail_whenRetrievingUserByEmail_IsPresent() {
        Optional<User> optionalUser = userRepository.findByEmail(new Email("Jeroen@admin.com"));

        Assertions.assertTrue(optionalUser.isPresent());
    }

    @Test
    @Sql("users.sql")
    public void givenIncorrectUserEmail_NoUserIsFoundInTheDatabase() {
        Optional<User> optionalUser = userRepository.findByEmail(new Email("jeroenDeMan@mail.com"));

        Assertions.assertTrue(optionalUser.isEmpty());
    }

    @Test
    @Sql("users.sql")
    public void givenAnExistingMail_expectedThatEmailAlreadyExist() {
        Assertions.assertTrue(userRepository.existsDistinctByEmail(new Email("jeroen@admin.com")));
    }

    @Test
    @Sql("users.sql")
    public void givenAnNewMail_expectedThatEmailDoesNotExist() {
        Assertions.assertFalse(userRepository.existsDistinctByEmail(new Email("jeroenDeMan@admin.com")));
    }

    @Test
    @Sql("users.sql")
    public void givenCorrectCoachID_coachIsRetrievedFromDatabase() {
        Optional<User> optionalUser = userRepository.findByCoach_Id(UUID.fromString("123e4567-e89b-42d3-a456-556642440000"));

        Assertions.assertTrue(optionalUser.isPresent());
    }

    @Test
    @Sql("users.sql")
    public void givenIncorrectCoachID_coachIsRetrievedFromDatabase() {
        Optional<User> optionalUser = userRepository.findByCoach_Id(UUID.fromString("fa6f0fce-a3c3-453c-827b-cd3579ebb576"));

        Assertions.assertTrue(optionalUser.isEmpty());
    }

    @Test
    @Sql("users.sql")
    public void requestingAllCoaches_ListSizeIs1() {

        Assertions.assertEquals(1, userRepository.findAllByCoachIsNotNull().size());
    }

}
