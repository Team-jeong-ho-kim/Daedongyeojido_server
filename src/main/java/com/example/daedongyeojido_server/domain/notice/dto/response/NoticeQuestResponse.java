package com.example.daedongyeojido_server.domain.notice.dto.response;

import com.example.daedongyeojido_server.domain.notice.domain.NoticeQuest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NoticeQuestResponse {

    private Long id;

    private String question;

    public NoticeQuestResponse(NoticeQuest noticeQuest) {
        id = noticeQuest.getId();
        question = noticeQuest.getQuestion1();
    }
}
