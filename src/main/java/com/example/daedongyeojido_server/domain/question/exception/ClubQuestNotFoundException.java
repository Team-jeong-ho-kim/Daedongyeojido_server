package com.example.daedongyeojido_server.domain.question.exception;

import com.example.daedongyeojido_server.global.error.exception.BusinessException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class ClubQuestNotFoundException extends BusinessException {

    public static final BusinessException EXCEPTION = new ClubQuestNotFoundException();

    public ClubQuestNotFoundException() {
        super(ErrorCode.CLUB_QUEST_NOT_FOUND);
    }
}