package com.switchfully.youcoach.user_management.user_domain;

import com.switchfully.youcoach.user_management.user_exceptions.EmailException;

import javax.persistence.Embeddable;

@Embeddable
public class Email {
    private String email;

    public Email(String email) {
        setEmail(email);
    }

    public Email() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (isValidEmailAddress(email)) {
            this.email = email;
        } else {
            throw new EmailException("Please enter a valid email");
        }
    }

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
}
