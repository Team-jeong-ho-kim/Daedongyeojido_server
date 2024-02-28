package com.example.daedongyeojido_server.domain.club.common.application;

import com.example.daedongyeojido_server.domain.report.application.facade.ReportFacade;
import com.example.daedongyeojido_server.domain.report.domain.Report;
import com.example.daedongyeojido_server.domain.club.common.dto.request.InterviewTimeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ChooseInterviewTimeService {

    private final ReportFacade reportFacade;

    @Transactional
    public void chooseInterviewTime(InterviewTimeRequest request) {
        Report report = reportFacade.reportFacade(request.getReportId());

        report.saveInterviewTime(request.getInterviewStartTime(), request.getInterviewEndTime());
    }
}
