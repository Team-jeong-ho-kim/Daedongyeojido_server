package com.example.daedongyeojido_server.domain.user.exception;

import com.example.daedongyeojido_server.global.error.exception.DaedongException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class UserMismatchException extends DaedongException {

    public static final DaedongException EXCEPTION = new UserMismatchException();

    public UserMismatchException() {
        super(ErrorCode.USER_MISMATCH);
    }
}
