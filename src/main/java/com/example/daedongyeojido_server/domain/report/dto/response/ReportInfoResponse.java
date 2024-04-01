package com.example.daedongyeojido_server.domain.report.dto.response;

import com.example.daedongyeojido_server.domain.report.domain.enums.PassingResult;
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

    private Boolean isApply;

    private PassingResult reportPassingResult;

    private List<ReportQuestResponse> noticeQuests;
}