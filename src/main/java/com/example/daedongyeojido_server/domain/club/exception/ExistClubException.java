package com.example.daedongyeojido_server.domain.club.exception;

import com.example.daedongyeojido_server.global.error.exception.DaedongException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class ExistClubException extends DaedongException {

    public static final DaedongException EXCEPTION = new ExistClubException();

    public ExistClubException() {
        super(ErrorCode.EXIST_CLUB);
    }
}