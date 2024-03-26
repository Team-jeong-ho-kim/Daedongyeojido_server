package com.example.daedongyeojido_server.domain.notice.exception;

import com.example.daedongyeojido_server.global.error.exception.DaedongException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class NoticeNotFoundException extends DaedongException {

    public static final DaedongException EXCEPTION = new NoticeNotFoundException();

    public NoticeNotFoundException() {
        super(ErrorCode.NOTICE_NOT_FOUND);
    }
}