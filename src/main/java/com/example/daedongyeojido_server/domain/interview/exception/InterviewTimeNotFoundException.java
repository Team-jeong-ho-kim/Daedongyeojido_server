package com.example.daedongyeojido_server.domain.interview.exception;

import com.example.daedongyeojido_server.global.error.exception.DaedongException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class InterviewTimeNotFoundException extends DaedongException {

    public static final DaedongException EXCEPTION = new InterviewTimeNotFoundException();

    public InterviewTimeNotFoundException() {
        super(ErrorCode.INTERVIEW_TIME_NOT_FOUND);
    }
}