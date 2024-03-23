package com.example.daedongyeojido_server.domain.Inquiry.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum InquiryType {

    SERVER("서버"),

    CLIENT("클라이언트");

    private final String name;
}
