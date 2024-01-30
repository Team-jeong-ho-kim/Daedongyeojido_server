package com.example.daedongyeojido_server.domain.report.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApplyRequest {

    @NotBlank
    @Size(max = 20, message = "oneLiner는 20글자 이하여야 합니다.")
    private String oneLiner;

    @NotBlank
    @Size(max = 100, message = "introduction은 100글자 이하여야 합니다.")
    private String introduction;

    @NotBlank
    @Size(max = 100, message = "hopeMajor는 100글자 이하여야 합니다.")
    private String hopeMajor;

    @NotBlank
    @Size(max = 100, message = "learn은 100글자 이하여야 합니다.")
    private String learn;

    @NotNull
    private Long noticeId;
}
