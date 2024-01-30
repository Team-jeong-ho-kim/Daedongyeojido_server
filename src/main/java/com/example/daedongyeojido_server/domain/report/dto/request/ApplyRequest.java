package com.example.daedongyeojido_server.domain.report.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApplyRequest {

    @Size(min = 4, max = 4, message = "classNumber는 4글자 이여야 합니다.")
    private String classNumber;

    @NotBlank
    @Size(min = 3, max = 4, message = "name은 3글자 이상, 4글자 이하여야 합니다.")
    private String name;

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

    @NotBlank
    private Long noticeId;
}
