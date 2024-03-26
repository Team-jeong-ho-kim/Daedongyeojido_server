package com.example.daedongyeojido_server.domain.club.exception;

import com.example.daedongyeojido_server.global.error.exception.DaedongException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class DuplicatedTagsException extends DaedongException {

    public static final DaedongException EXCEPTION = new DuplicatedTagsException();

    public DuplicatedTagsException() {
        super(ErrorCode.DUPLICATED_TAGS);
    }
}
