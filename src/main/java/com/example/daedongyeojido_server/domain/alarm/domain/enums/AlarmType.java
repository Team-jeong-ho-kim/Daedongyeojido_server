package com.example.daedongyeojido_server.domain.alarm.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AlarmType {

    ANNOUNCEMENT("공지사항"),

    PASS_RESULT("합격여부"),

    MESS_ACCEPT("회식수락");

    private final String name;
}
