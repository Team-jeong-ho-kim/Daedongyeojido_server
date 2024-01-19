package com.example.daedongyeojido_server.domain.user.exception;

import com.example.daedongyeojido_server.global.error.exception.BusinessException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class ExistUserException extends BusinessException {

    public static final BusinessException EXCEPTION = new ExistUserException();

    public ExistUserException() {
        super(ErrorCode.EXIST_USER);
    }
}
