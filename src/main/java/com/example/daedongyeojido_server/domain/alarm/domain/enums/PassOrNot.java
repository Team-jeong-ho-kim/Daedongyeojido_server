package com.example.daedongyeojido_server.domain.alarm.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
@RequiredArgsConstructor
public enum PassOrNot
{
    PASS("합격"),
    NOT ("불합격");

    private final String name;
}