package com.example.daedongyeojido_server.domain.notice.exception;

import com.example.daedongyeojido_server.global.error.exception.BusinessException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class NoticeNotFoundException extends BusinessException {

    public static final BusinessException EXCEPTION = new NoticeNotFoundException();

    public NoticeNotFoundException() {
        super(ErrorCode.NOTICE_NOT_FOUND);
    }
}