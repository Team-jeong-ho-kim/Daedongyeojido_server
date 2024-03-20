package com.example.daedongyeojido_server.domain.notice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateNoticeRequest {

    @NotBlank
    @Size(min = 1, max = 20, message = "동아리 이름은 1글자 이상, 20글자 이하여야 합니다.")
    private String clubName;

    @NotBlank
    private String noticeTitle;

    @NotBlank
    private String noticeExplain;

    @NotNull
    private List<FieldRequest> fields;

    @NotNull
    private StartAndEndTimeRequest recruitDay;

    @NotBlank
    private String applyMethod;

    @NotNull
    private StartAndEndTimeRequest interviewDay;

    @NotBlank
    private String inquiry;

    @NotBlank
    private String weWant;

    @NotBlank
    private String assignment;
}