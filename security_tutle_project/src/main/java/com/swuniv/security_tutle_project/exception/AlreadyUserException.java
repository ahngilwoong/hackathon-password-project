package com.swuniv.security_tutle_project.exception;

public class AlreadyUserException extends RuntimeException{
    public AlreadyUserException(String message) {
        super(message);
    }
}
