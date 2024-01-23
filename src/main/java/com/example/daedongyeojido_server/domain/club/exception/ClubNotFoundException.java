package com.example.daedongyeojido_server.domain.club.exception;

import com.example.daedongyeojido_server.global.error.exception.BusinessException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class ClubNotFoundException extends BusinessException {

    public static final BusinessException EXCEPTION = new ClubNotFoundException();

    public ClubNotFoundException() {
        super(ErrorCode.CLUB_NOT_FOUND);
    }
}