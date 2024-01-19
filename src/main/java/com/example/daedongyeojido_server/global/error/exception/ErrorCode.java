package com.example.daedongyeojido_server.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    // jwt
    EXPIRED_TOKEN(401 , "Expired token"),
    INVALID_TOKEN(401, "Invalid token"),

    // user
    USER_NOT_FOUND(404, "User not found"),
    EXIST_USER(409, "동일한 학번을 가진 학생이 존재합니다."),

    // club
    CLUB_NOT_FOUND(404, "Club not found"),
    EXIST_CLUB(409, "동일한 이름의 동아리가 존재합니다."),

    // general
    BAD_REQUEST(400, "Bad request"),
    INTERNAL_SERVER_ERROR(500, "Internal server error");

    private final int statusCode;
    private final String message;
}
