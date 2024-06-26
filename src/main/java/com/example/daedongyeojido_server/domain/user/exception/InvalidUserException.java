package com.example.daedongyeojido_server.domain.user.exception;

import com.example.daedongyeojido_server.global.error.exception.DaedongException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class InvalidUserException extends DaedongException {

    public static final DaedongException EXCEPTION = new InvalidUserException();

    public InvalidUserException() {
        super(ErrorCode.INVALID_USER);
    }
}
