package com.example.daedongyeojido_server.domain.question.exception;

import com.example.daedongyeojido_server.global.error.exception.DaedongException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class ClubQuestNotFoundException extends DaedongException {

    public static final DaedongException EXCEPTION = new ClubQuestNotFoundException();

    public ClubQuestNotFoundException() {
        super(ErrorCode.CLUB_QUEST_NOT_FOUND);
    }
}