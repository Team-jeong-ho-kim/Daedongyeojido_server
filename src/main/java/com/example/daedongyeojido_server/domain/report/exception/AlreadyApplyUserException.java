package com.example.daedongyeojido_server.domain.report.exception;

import com.example.daedongyeojido_server.global.error.exception.BusinessException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class AlreadyApplyUserException extends BusinessException {

    public static final BusinessException EXCEPTION = new AlreadyApplyUserException();

    public AlreadyApplyUserException() {
        super(ErrorCode.ALREADY_APPLY_USER);
    }
}
