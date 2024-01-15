package com.example.daedongyeojido_server.domain.user.exception;

import com.example.daedongyeojido_server.global.error.exception.BusinessException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class UserNotFoundException extends BusinessException {

    public static final BusinessException EXCEPTION = new UserNotFoundException();

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }

}

