package com.example.daedongyeojido_server.domain.report.dto.response;

import com.example.daedongyeojido_server.domain.notice.domain.enums.Major;
import com.example.daedongyeojido_server.domain.report.domain.Report;
import com.example.daedongyeojido_server.domain.report.domain.enums.PassingResult;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ReportResponse {

    private Long reportId;

    private String classNumber;

    private String name;

    private Major hopeMajor;

    private LocalDateTime interviewStartTime;

    private LocalDateTime interviewEndTime;

    private PassingResult reportPassingResult;

    private PassingResult interviewPassingResult;

    public ReportResponse(Report report) {
        reportId = report.getReportId();
        classNumber = report.getClassNumber();
        name = report.getName();
        hopeMajor = report.getNotice().getMajor();
        interviewStartTime = report.getInterviewStartTime();
        interviewEndTime = report.getInterviewEndTime();
        reportPassingResult = report.getReportPassingResult();
        interviewPassingResult = report.getInterviewPassingResult();
    }
}