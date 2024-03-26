package com.example.daedongyeojido_server.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DaedongException extends RuntimeException {
    private final ErrorCode errorCode;
}
