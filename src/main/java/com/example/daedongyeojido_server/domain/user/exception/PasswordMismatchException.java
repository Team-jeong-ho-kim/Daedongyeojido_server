package com.example.daedongyeojido_server.domain.user.exception;

import com.example.daedongyeojido_server.global.error.exception.DaedongException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class PasswordMismatchException extends DaedongException {

    public static final DaedongException EXCEPTION = new PasswordMismatchException();

    public PasswordMismatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}
