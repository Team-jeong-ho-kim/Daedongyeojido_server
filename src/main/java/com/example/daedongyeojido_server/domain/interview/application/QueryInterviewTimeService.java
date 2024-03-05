package com.example.daedongyeojido_server.domain.interview.application;

import com.example.daedongyeojido_server.domain.interview.dao.InterviewTimeRepository;
import com.example.daedongyeojido_server.domain.interview.dto.response.InterviewTimeResponse;
import com.example.daedongyeojido_server.domain.report.application.facade.ReportFacade;
import com.example.daedongyeojido_server.domain.report.domain.Report;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryInterviewTimeService {

    private final ReportFacade reportFacade;

    private final InterviewTimeRepository interviewTimeRepository;

    @Transactional(readOnly = true)
    public List<InterviewTimeResponse> queryInterviewTime(Long reportId) {
        Report report = reportFacade.reportFacade(reportId);

        return interviewTimeRepository.findAllByClubName(report.getNotice().getClubName().getClubName())
                .stream()
                .map(InterviewTimeResponse::new)
                .collect(Collectors.toList());
    }
}