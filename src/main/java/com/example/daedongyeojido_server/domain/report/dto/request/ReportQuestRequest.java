package com.example.daedongyeojido_server.domain.report.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReportQuestRequest {

    @NotNull
    private Long noticeQuestId;

    @NotBlank
    private String answer;
}
