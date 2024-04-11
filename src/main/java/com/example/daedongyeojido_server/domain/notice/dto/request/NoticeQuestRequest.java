package com.example.daedongyeojido_server.domain.notice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NoticeQuestRequest {

    @NotNull
    private Long noticeId;

    @NotBlank
    private String question;
}
