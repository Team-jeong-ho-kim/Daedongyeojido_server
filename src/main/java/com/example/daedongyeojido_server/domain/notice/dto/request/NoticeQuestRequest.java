package com.example.daedongyeojido_server.domain.notice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NoticeQuestRequest {

    @NotNull
    private Long noticeId;

    @NotBlank
    @Size(min = 1, max = 30, message = "질문은 1글자 이상, 30글자 이하여야 합니다.")
    private String question;
}
