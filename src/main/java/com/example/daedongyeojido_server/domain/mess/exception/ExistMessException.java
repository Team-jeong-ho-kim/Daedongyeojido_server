package com.example.daedongyeojido_server.domain.mess.exception;

import com.example.daedongyeojido_server.global.error.exception.BusinessException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class ExistMessException extends BusinessException {

    public static final BusinessException EXCEPTION = new ExistMessException();

    public ExistMessException() {
        super(ErrorCode.EXIST_MESS);
    }
}