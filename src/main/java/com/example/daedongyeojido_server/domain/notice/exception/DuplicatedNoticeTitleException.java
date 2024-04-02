package com.example.daedongyeojido_server.domain.notice.exception;

import com.example.daedongyeojido_server.global.error.exception.DaedongException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class DuplicatedNoticeTitleException extends DaedongException {

    public static final DaedongException EXCEPTION = new DuplicatedNoticeTitleException();

    public DuplicatedNoticeTitleException() {
        super(ErrorCode.DUPLICATED_NOTICE_TITLE);
    }
}
