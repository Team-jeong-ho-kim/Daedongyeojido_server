package com.example.daedongyeojido_server.domain.club.exception;

import com.example.daedongyeojido_server.global.error.exception.DaedongException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class ClubNotFoundException extends DaedongException {

    public static final DaedongException EXCEPTION = new ClubNotFoundException();

    public ClubNotFoundException() {
        super(ErrorCode.CLUB_NOT_FOUND);
    }
}