package com.example.daedongyeojido_server.domain.club.common.application;

import com.example.daedongyeojido_server.domain.club.common.dao.InterviewTimeRepository;
import com.example.daedongyeojido_server.domain.club.common.domain.InterviewTime;
import com.example.daedongyeojido_server.domain.club.common.dto.request.ChooseInterviewRequest;
import com.example.daedongyeojido_server.domain.club.common.exception.InterviewTimeNotFoundException;
import com.example.daedongyeojido_server.domain.report.application.facade.ReportFacade;
import com.example.daedongyeojido_server.domain.report.domain.Report;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ChooseInterviewTimeService {

    private final ReportFacade reportFacade;

    private final InterviewTimeRepository interviewTimeRepository;

    @Transactional
    public void chooseInterviewTime(ChooseInterviewRequest request) {
        Report report = reportFacade.reportFacade(request.getReportId());

        InterviewTime interviewTime = interviewTimeRepository.findById(request.getInterviewTimeId())
                        .orElseThrow(()-> InterviewTimeNotFoundException.EXCEPTION);

        report.saveInterviewTime(interviewTime.getInterviewStartTime(), interviewTime.getInterviewEndTime());
        interviewTimeRepository.deleteById(request.getInterviewTimeId());
    }
}
