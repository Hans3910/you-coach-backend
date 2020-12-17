package com.switchfully.youcoach.user_management.user_domain.repository;

import com.switchfully.youcoach.user_management.user_domain.entity.Email;
import com.switchfully.youcoach.user_management.user_domain.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    @Sql("users.sql")
    public void givenCorrectUserEmail_whenRetrievingUserByEmail_IsPresent() {
        Optional<User> optionalUser = userRepository.findByEmail(new Email("jeroen@admin.com"));

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



}
