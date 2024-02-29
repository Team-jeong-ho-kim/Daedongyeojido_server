package com.example.daedongyeojido_server.domain.alarm.exception;

import com.example.daedongyeojido_server.global.error.exception.BusinessException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class WrongAlarmTypeException extends BusinessException {

    public static final BusinessException EXCEPTION = new WrongAlarmTypeException();

    public WrongAlarmTypeException() {
        super(ErrorCode.WRONG_ALARM_TYPE);
    }
}