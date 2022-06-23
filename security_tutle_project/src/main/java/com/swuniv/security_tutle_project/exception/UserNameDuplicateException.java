package com.swuniv.security_tutle_project.exception;

public class UserNameDuplicateException extends RuntimeException{

    public UserNameDuplicateException(String message) {
        super(message);
    }
}
