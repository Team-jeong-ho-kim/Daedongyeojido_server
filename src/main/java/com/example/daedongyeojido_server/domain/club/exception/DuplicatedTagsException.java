package com.example.daedongyeojido_server.domain.club.exception;

import com.example.daedongyeojido_server.global.error.exception.BusinessException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class DuplicatedTagsException extends BusinessException {

    public static final BusinessException EXCEPTION = new DuplicatedTagsException();

    public DuplicatedTagsException() {
        super(ErrorCode.DUPLICATED_TAGS);
    }
}
