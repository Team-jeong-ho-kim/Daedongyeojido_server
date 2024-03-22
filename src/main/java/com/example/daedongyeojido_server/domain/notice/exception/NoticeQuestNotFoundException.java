package com.example.daedongyeojido_server.domain.notice.exception;

import com.example.daedongyeojido_server.global.error.exception.BusinessException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class NoticeQuestNotFoundException extends BusinessException {

    public static final BusinessException EXCEPTION = new NoticeQuestNotFoundException();

    public NoticeQuestNotFoundException() {
        super(ErrorCode.NOTICE_QUEST_NOT_FOUND);
    }
}
