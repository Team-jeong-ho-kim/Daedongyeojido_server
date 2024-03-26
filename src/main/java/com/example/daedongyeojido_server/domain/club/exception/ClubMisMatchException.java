package com.example.daedongyeojido_server.domain.club.exception;

import com.example.daedongyeojido_server.global.error.exception.DaedongException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class ClubMisMatchException extends DaedongException {

    public static final DaedongException EXCEPTION = new ClubMisMatchException();

    public ClubMisMatchException() {
        super(ErrorCode.CLUB_MIS_MATCH);
    }
}