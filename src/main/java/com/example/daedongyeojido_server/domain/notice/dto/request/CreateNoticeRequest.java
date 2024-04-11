package com.example.daedongyeojido_server.domain.notice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateNoticeRequest {

    @NotBlank
    private String clubName;

    @NotBlank
    private String noticeTitle;

    @NotBlank
    private String noticeExplain;

    @NotBlank
    private String clubExplain;

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