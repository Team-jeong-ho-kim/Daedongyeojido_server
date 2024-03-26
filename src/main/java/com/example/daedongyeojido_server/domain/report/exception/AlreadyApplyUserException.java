package com.example.daedongyeojido_server.domain.report.exception;

import com.example.daedongyeojido_server.global.error.exception.DaedongException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class AlreadyApplyUserException extends DaedongException {

    public static final DaedongException EXCEPTION = new AlreadyApplyUserException();

    public AlreadyApplyUserException() {
        super(ErrorCode.ALREADY_APPLY_USER);
    }
}
