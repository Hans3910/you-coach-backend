package com.switchfully.youcoach.user_management.user_exceptions;

public class EmailException extends RuntimeException {
    private String emailExceptionMessage;

    public EmailException(String emailExceptionMessage) {
        this.emailExceptionMessage = emailExceptionMessage;
    }

    @Override
    public String getMessage() {
        return emailExceptionMessage;
    }
}
