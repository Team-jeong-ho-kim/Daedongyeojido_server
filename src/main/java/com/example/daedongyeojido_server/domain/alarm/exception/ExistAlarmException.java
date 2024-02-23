package com.example.daedongyeojido_server.domain.alarm.exception;

import com.example.daedongyeojido_server.global.error.exception.BusinessException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class ExistAlarmException extends BusinessException {

    public static final BusinessException EXCEPTION = new ExistAlarmException();

    public ExistAlarmException() {
        super(ErrorCode.EXIST_ALARM);
    }
}