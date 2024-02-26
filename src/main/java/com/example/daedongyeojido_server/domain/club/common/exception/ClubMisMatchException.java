package com.example.daedongyeojido_server.domain.club.common.exception;

import com.example.daedongyeojido_server.global.error.exception.BusinessException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class ClubMisMatchException extends BusinessException {

    public static final BusinessException EXCEPTION = new ClubMisMatchException();

    public ClubMisMatchException() {
        super(ErrorCode.CLUB_NOT_FOUND);
    }
}
