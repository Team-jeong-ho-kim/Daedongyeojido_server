package com.example.daedongyeojido_server.domain.interview.exception;

import com.example.daedongyeojido_server.global.error.exception.BusinessException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class InterviewTimeNotFoundException extends BusinessException {

    public static final BusinessException EXCEPTION = new InterviewTimeNotFoundException();

    public InterviewTimeNotFoundException() {
        super(ErrorCode.INTERVIEW_TIME_NOT_FOUND);
    }
}