package com.example.daedongyeojido_server.domain.report.dto.request;

import com.example.daedongyeojido_server.domain.notice.domain.enums.Major;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApplyRequest {

    @NotNull
    private Long noticeId;

    @NotBlank
    private String introduce;

    @NotNull
    private Major major;

    @NotNull
    private List<ReportQuestRequest> reportQuests;
}