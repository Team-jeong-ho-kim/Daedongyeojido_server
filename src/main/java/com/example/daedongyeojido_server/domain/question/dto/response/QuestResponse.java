package com.example.daedongyeojido_server.domain.question.dto.response;

import com.example.daedongyeojido_server.domain.question.domain.QandA;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuestResponse {

    private Long questionId;

    private String question;

    private String answer;

    public QuestResponse(QandA qandA) {
        questionId = qandA.getQuestionId();
        question = qandA.getQuestion();
        answer = qandA.getAnswer();
    }
}
