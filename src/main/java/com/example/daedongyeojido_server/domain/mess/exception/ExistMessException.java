package com.example.daedongyeojido_server.domain.mess.exception;

import com.example.daedongyeojido_server.global.error.exception.DaedongException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class ExistMessException extends DaedongException {

    public static final DaedongException EXCEPTION = new ExistMessException();

    public ExistMessException() {
        super(ErrorCode.EXIST_MESS);
    }
}