package com.switchfully.youcoach.exceptions;

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
