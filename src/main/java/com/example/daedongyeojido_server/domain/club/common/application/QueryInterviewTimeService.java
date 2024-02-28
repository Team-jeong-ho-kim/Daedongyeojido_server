package com.example.daedongyeojido_server.domain.club.common.application;

import com.example.daedongyeojido_server.domain.club.common.dao.InterviewTimeRepository;
import com.example.daedongyeojido_server.domain.club.common.domain.InterviewTime;
import com.example.daedongyeojido_server.domain.report.dao.ReportRepository;
import com.example.daedongyeojido_server.domain.report.domain.Report;
import com.example.daedongyeojido_server.domain.report.exception.ReportNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryInterviewTimeService {

    private final ReportRepository reportRepository;

    private final InterviewTimeRepository interviewTimeRepository;

    @Transactional(readOnly = true)
    public List<InterviewTime> queryInterviewTime(Long reportId) {
        Report report = reportRepository.findById(reportId)
                .orElseThrow(()-> ReportNotFoundException.EXCEPTION);

        return interviewTimeRepository.findAllByClubName(report.getNotice().getClubName().getClubName());
    }
}
