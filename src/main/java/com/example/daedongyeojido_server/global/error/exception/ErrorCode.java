package com.example.daedongyeojido_server.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    // jwt
    EXPIRED_TOKEN(401 , "만료된 토큰입니다."),
    INVALID_TOKEN(401, "검증되지 않은 토큰입니다."),

    // user
    USER_NOT_FOUND(404, "일치하는 학생이 존재하지 않습니다."),
    EXIST_USER(409, "동일한 학번을 가진 학생이 존재합니다."),

    // club
    CLUB_NOT_FOUND(404, "일치하는 동아리가 존재하지 않습니다."),
    EXIST_CLUB(409, "동일한 이름의 동아리가 존재합니다."),

    // general
    BAD_REQUEST(400, "프론트 탓..."),
    INTERNAL_SERVER_ERROR(500, "서버 탓...");

    private final int statusCode;
    private final String message;
}
