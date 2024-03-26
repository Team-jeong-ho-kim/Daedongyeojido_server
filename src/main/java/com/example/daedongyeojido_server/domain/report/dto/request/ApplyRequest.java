package com.example.daedongyeojido_server.domain.report.dto.request;

import com.example.daedongyeojido_server.domain.notice.domain.enums.Major;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @Size(max = 30, message = "자기소개는 300글자 이하여야 합니다.")
    private String introduce;

    @NotNull
    private Major major;

    @NotNull
    private List<ReportQuestRequest> reportQuests;
}