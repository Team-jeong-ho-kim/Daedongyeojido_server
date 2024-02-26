package com.example.daedongyeojido_server.domain.report.application;

import com.example.daedongyeojido_server.domain.report.dao.ReportRepository;
import com.example.daedongyeojido_server.domain.report.domain.Report;
import com.example.daedongyeojido_server.domain.report.dto.response.ReportInfoResponse;
import com.example.daedongyeojido_server.domain.report.exception.ReportNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReportInfoService {

    private final ReportRepository reportRepository;

    @Transactional(readOnly = true)
    public ReportInfoResponse reportInfo(Long reportId) {
        Report report = reportRepository.findById(reportId)
                .orElseThrow(()-> ReportNotFoundException.EXCEPTION);

        return ReportInfoResponse.builder()
                .classNumber(report.getClassNumber())
                .name(report.getName())
                .reportPassingResult(report.getReportPassingResult())
                .oneLiner(report.getOneLiner())
                .introduction(report.getIntroduction())
                .hopeMajor(report.getHopeMajor())
                .learn(report.getLearn())
                .build();
    }
}
