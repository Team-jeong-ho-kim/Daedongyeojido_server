package com.example.daedongyeojido_server.domain.report.dto.response;

import com.example.daedongyeojido_server.domain.report.domain.ReportQuest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReportQuestResponse {

    private String question;

    private String answer;

    public ReportQuestResponse(ReportQuest reportQuest) {
        question = reportQuest.getQuestion();
        answer = reportQuest.getAnswer();
    }
}
