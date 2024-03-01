package com.example.daedongyeojido_server.domain.user.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Part {

    INDEPENDENT("무소속"),

    CLUB_MEMBER("동아리원"),

    CLUB_LEADER("동아리장"),

    TEACHER("선생님"),

    CLUB_LEADER_TEACHER("전공동아리 담당 선생님"),

    ADMIN("관리자"),

    ERROR("에러");

    private final String name;
}