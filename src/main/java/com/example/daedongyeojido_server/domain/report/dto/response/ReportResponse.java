package com.example.daedongyeojido_server.domain.report.dto.response;

import com.example.daedongyeojido_server.domain.notice.domain.enums.Major;
import com.example.daedongyeojido_server.domain.report.domain.Report;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReportResponse {

    private Long reportId;

    private String classNumber;

    private String name;

    private Major hopeMajor;

    public ReportResponse(Report report) {
        reportId = report.getReportId();
        classNumber = report.getClassNumber();
        name = report.getName();
        hopeMajor = report.getNotice().getMajor();
    }
}
