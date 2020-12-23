package com.switchfully.youcoach.user_management.user_domain;

import com.switchfully.youcoach.user_management.user_domain.entity.Email;
import com.switchfully.youcoach.exceptions.EmailException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

    @Test
    void givenTwoEqualEmails_OneWithCapitalAndOneWithLowerCase_ExpectedToBeEqual(){
        Email email = new Email("hans@hans.com");
        Email email1 = new Email("Hans@hans.com");
        Assertions.assertEquals(email, email1);
    }
}
