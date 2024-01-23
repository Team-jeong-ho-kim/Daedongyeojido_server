package com.example.daedongyeojido_server.domain.club.exception;

import com.example.daedongyeojido_server.global.error.exception.BusinessException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class ExistClubException extends BusinessException {

    public static final BusinessException EXCEPTION = new ExistClubException();

    public ExistClubException() {
        super(ErrorCode.EXIST_CLUB);
    }
}