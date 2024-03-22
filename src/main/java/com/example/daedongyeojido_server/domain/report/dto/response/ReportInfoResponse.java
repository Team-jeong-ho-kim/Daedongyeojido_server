package com.example.daedongyeojido_server.domain.report.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ReportInfoResponse {

    private String classNumber;

    private String name;

    private String introduce;

    private List<ReportQuestResponse> noticeQuests;
}