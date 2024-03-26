package com.example.daedongyeojido_server.domain.notice.exception;

import com.example.daedongyeojido_server.global.error.exception.DaedongException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class NoticeQuestNotFoundException extends DaedongException {

    public static final DaedongException EXCEPTION = new NoticeQuestNotFoundException();

    public NoticeQuestNotFoundException() {
        super(ErrorCode.NOTICE_QUEST_NOT_FOUND);
    }
}
