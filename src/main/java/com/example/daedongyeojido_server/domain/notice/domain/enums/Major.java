package com.example.daedongyeojido_server.domain.notice.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Major {

    FRONT("프론트엔드"),

    BACK("백엔드"),

    IOS("아이오에스"),

    AND("안드로이드"),

    FLUTTER("플러터"),

    EMBEDDED("임베디드"),

    AI("인공지능"),

    SECURITY("보안"),

    DEVOPS("데브옵스"),

    DESIGN("디자인"),

    GAME("게임개발");

    private final String name;
}
