package com.example.daedongyeojido_server.domain.user.dto.response;

import com.example.daedongyeojido_server.domain.notice.domain.enums.Major;
import com.example.daedongyeojido_server.domain.report.domain.Report;
import com.example.daedongyeojido_server.domain.report.domain.enums.PassingResult;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class MyReportResponse {

    private Long id;

    private String clubName;

    private Major hopeMajor;

    private LocalDate deadline;

    private PassingResult reportPassingResult;

    private PassingResult interviewPassingResult;

    private LocalDateTime interviewStartTime;

    private LocalDateTime interviewEndTime;

    public MyReportResponse(Report report) {
        id = report.getReportId();
        clubName = report.getNotice().getClubName().getClubName();
        hopeMajor = report.getMajor();
        deadline = report.getNotice().getRecruitDay().getEndDay();
        reportPassingResult = report.getReportPassingResult();
        interviewPassingResult = report.getInterviewPassingResult();
        interviewStartTime = report.getInterviewStartTime();
        interviewEndTime = report.getInterviewEndTime();
    }
}