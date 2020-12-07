package com.switchfully.youcoach.user_management.user_exceptions;

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
