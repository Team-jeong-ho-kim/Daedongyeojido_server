package com.example.daedongyeojido_server.domain.report.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SaveReportQuestRequest {

    private String question;

    private String answer;
}
