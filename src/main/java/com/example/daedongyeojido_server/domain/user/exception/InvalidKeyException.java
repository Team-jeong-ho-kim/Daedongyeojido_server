package com.example.daedongyeojido_server.domain.user.exception;

import com.example.daedongyeojido_server.global.error.exception.BusinessException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class InvalidKeyException extends BusinessException {

    public static final BusinessException EXCEPTION = new InvalidKeyException();

    public InvalidKeyException() {
        super(ErrorCode.INVALID_KEY);
    }
}
