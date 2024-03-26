package com.example.daedongyeojido_server.domain.alarm.exception;

import com.example.daedongyeojido_server.global.error.exception.DaedongException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class WrongAlarmTypeException extends DaedongException {

    public static final DaedongException EXCEPTION = new WrongAlarmTypeException();

    public WrongAlarmTypeException() {
        super(ErrorCode.WRONG_ALARM_TYPE);
    }
}