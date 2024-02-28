package com.example.daedongyeojido_server.domain.club.common.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InterviewTimeRequest {

    @NotNull
    private LocalDateTime interviewStartTime;

    @NotNull
    private LocalDateTime interviewEndTime;
}
