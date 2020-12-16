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
    public void blancTest() {

    }


    @Test
    @Sql("users.sql")
    public void givenCorrectUserEmail_whenRetrievingUserByEmail_IsPresent() {
        Optional<User> optionalUser = userRepository.findByEmail(new Email("jeroen@admin.com"));

        Assertions.assertTrue(optionalUser.isPresent());
    }

}
