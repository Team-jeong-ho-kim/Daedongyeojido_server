package com.example.daedongyeojido_server.domain.club.common.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChooseInterviewRequest {

    @NotNull
    private Long reportId;

    @NotNull
    private Long interviewTimeId;
}
