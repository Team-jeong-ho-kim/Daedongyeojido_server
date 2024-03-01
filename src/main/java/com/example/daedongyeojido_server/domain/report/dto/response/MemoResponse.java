package com.example.daedongyeojido_server.domain.report.dto.response;

import com.example.daedongyeojido_server.domain.notice.domain.enums.Major;
import com.example.daedongyeojido_server.domain.report.domain.enums.PassingResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MemoResponse {

    private String classNumber;

    private String name;

    private Major major;

    private PassingResult interviewPassingResult;

    private String memo;
}