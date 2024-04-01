package com.example.daedongyeojido_server.domain.notice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class NoticeInfoResponse {

    private Boolean isApply;

    private String clubName;

    private String noticeTitle;

    private String noticeExplain;

    private String clubExplain;

    private List<FieldResponse> fields;

    private StartAndEndTimeResponse recruitDay;

    private String applyMethod;

    private StartAndEndTimeResponse interviewDay;

    private String inquiry;

    private String weWant;

    private String assignment;
}
