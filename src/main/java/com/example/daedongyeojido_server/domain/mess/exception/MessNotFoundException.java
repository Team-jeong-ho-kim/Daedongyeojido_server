package com.example.daedongyeojido_server.domain.mess.exception;

import com.example.daedongyeojido_server.global.error.exception.DaedongException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class MessNotFoundException extends DaedongException {

    public static final DaedongException EXCEPTION = new com.example.daedongyeojido_server.domain.mess.exception.MessNotFoundException();

    public MessNotFoundException() {
        super(ErrorCode.MESS_NOT_FOUND);
    }
}