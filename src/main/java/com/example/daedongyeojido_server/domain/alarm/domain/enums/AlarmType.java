package com.example.daedongyeojido_server.domain.alarm.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AlarmType {

    REPORT_PASS_RESULT("서류합격여부"),

    INTERVIEW_PASS_RESULT("면접합격여부"),

    MESS_ACCEPT("회식수락");

    private final String name;
}