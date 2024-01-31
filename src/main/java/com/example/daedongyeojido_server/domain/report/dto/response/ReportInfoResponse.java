package com.example.daedongyeojido_server.domain.report.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ReportInfoResponse {

    private String classNumber;

    private String name;

    private String oneLiner;

    private String introduction;

    private String hopeMajor;

    private String learn;
}
