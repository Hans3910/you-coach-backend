package com.switchfully.youcoach.user_management.user_domain;

import com.switchfully.youcoach.user_management.user_exceptions.EmailException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void givenValidMailAddress_ICanCreateAnEmail() {
        Email email = new Email("guillermosaezgomez@yahoo.be");
        Assertions.assertEquals(email.getEmail(), "guillermosaezgomez@yahoo.be");
    }

    @Test
    void givenInvalidString_EmailExceptionIsThrown() {
        Assertions.assertThrows(EmailException.class, () -> new Email("Invalid email"));
    }
}
