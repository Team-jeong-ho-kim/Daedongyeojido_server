package com.example.daedongyeojido_server.domain.user.exception;

public class NotAuthenticatedException extends RuntimeException {

    public NotAuthenticatedException(String message) {
        super(message);
    }
}
