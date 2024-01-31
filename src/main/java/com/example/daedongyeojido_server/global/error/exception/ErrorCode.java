package com.example.daedongyeojido_server.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    //alarm
    ALARM_NOT_FOUND(404, "일치하는 알림이 존재하지 않습니다"),
    EXIST_ALARM(409, "동일한 알림이 존재합니다."),

    // jwt
    EXPIRED_TOKEN(401 , "만료된 토큰입니다."),
    INVALID_TOKEN(401, "검증되지 않은 토큰입니다."),

    // user
    USER_NOT_FOUND(404, "일치하는 유저가 존재하지 않습니다."),

    // club
    CLUB_NOT_FOUND(404, "일치하는 동아리가 존재하지 않습니다."),
    EXIST_CLUB(409, "동일한 이름의 동아리가 존재합니다."),

    // notice
    NOTICE_NOT_FOUND(404, "일치하는 공고가 존재하지 않습니다."),

    // report
    REPORT_NOT_FOUND(404, "일치하는 지원서가 존재하지 않습니다."),

    // mess
    MESS_NOT_FOUND(404, "일치하는 회식이 존재하지 않습니다"),
    EXIST_MESS(409, "동일한 회식 신청이 존재합니다."),

    // general
    BAD_REQUEST(400, "프론트 탓..."),
    INTERNAL_SERVER_ERROR(500, "서버 탓...");

    private final int statusCode;
    private final String message;
}
