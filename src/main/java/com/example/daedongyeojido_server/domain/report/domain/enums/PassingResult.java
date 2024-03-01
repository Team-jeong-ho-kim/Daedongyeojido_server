package com.example.daedongyeojido_server.domain.report.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PassingResult {

    PASS("합격"),

    FAIL("불합격"),

    WAIT("대기");

    private final String name;
}