package com.example.daedongyeojido_server.domain.alarm.exception;

import com.example.daedongyeojido_server.global.error.exception.BusinessException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class NotValidTeacherException extends BusinessException {

    public static final BusinessException EXCEPTION = new NotValidTeacherException();

    public NotValidTeacherException() {
        super(ErrorCode.NOT_VALID_TEACHER);
    }
}
