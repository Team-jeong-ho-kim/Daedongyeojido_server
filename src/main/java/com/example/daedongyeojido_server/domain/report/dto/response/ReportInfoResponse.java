package com.example.daedongyeojido_server.domain.report.dto.response;

import com.example.daedongyeojido_server.domain.report.domain.enums.PassingResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ReportInfoResponse {

    private String classNumber;

    private String name;

    private PassingResult reportPassingResult;

    private String oneLiner;

    private String introduction;

    private String hopeMajor;

    private String learn;
}