package com.example.daedongyeojido_server.domain.interview.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeleteInterviewTimeRequest {

    @NotBlank
    private String clubName;

    @NotNull
    private Long interviewTimeId;
}
