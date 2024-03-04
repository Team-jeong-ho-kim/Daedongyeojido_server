package com.example.daedongyeojido_server.domain.question.dto.response;

import com.example.daedongyeojido_server.domain.question.domain.ClubQuest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuestResponse {

    private Long questionId;

    private String question;

    private String answer;

    public QuestResponse(ClubQuest clubQuest) {
        questionId = clubQuest.getClubQuestId();
        question = clubQuest.getQuestion();
        answer = clubQuest.getAnswer();
    }
}
