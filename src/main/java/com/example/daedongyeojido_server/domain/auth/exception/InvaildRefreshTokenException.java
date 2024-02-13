package com.example.daedongyeojido_server.domain.auth.exception;

import com.example.daedongyeojido_server.global.error.exception.BusinessException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class InvaildRefreshTokenException extends BusinessException {

    public static final BusinessException EXCEPTION = new InvaildRefreshTokenException();

    private InvaildRefreshTokenException() {
        super(ErrorCode.INVALID_REFRESH_TOKEN);
    }
}