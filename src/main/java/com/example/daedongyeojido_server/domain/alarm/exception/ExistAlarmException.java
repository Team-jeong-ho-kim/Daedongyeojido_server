package com.example.daedongyeojido_server.domain.alarm.exception;

import com.example.daedongyeojido_server.global.error.exception.DaedongException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class ExistAlarmException extends DaedongException {

    public static final DaedongException EXCEPTION = new ExistAlarmException();

    public ExistAlarmException() {
        super(ErrorCode.EXIST_ALARM);
    }
}