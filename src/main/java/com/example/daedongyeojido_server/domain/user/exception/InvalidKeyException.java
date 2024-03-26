package com.example.daedongyeojido_server.domain.user.exception;

import com.example.daedongyeojido_server.global.error.exception.DaedongException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class InvalidKeyException extends DaedongException {

    public static final DaedongException EXCEPTION = new InvalidKeyException();

    public InvalidKeyException() {
        super(ErrorCode.INVALID_KEY);
    }
}