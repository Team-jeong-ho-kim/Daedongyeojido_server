package com.example.daedongyeojido_server.domain.alarm.exception;

import com.example.daedongyeojido_server.global.error.exception.DaedongException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class NotValidTeacherException extends DaedongException {

    public static final DaedongException EXCEPTION = new NotValidTeacherException();

    public NotValidTeacherException() {
        super(ErrorCode.NOT_VALID_TEACHER);
    }
}