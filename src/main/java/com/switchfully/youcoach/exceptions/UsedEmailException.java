package com.switchfully.youcoach.exceptions;

public class UsedEmailException extends RuntimeException {
    private String emailExceptionMessage;

    public UsedEmailException(String emailExceptionMessage) {
        this.emailExceptionMessage = emailExceptionMessage;
    }

    @Override
    public String getMessage() {
        return emailExceptionMessage;
    }
}
