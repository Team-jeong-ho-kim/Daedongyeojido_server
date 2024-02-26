package com.example.daedongyeojido_server.domain.report.application.facade;

import com.example.daedongyeojido_server.domain.report.dao.ReportRepository;
import com.example.daedongyeojido_server.domain.report.domain.Report;
import com.example.daedongyeojido_server.domain.report.exception.ReportNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReportFacade {

    private final ReportRepository reportRepository;

    public Report reportFacade(Long reportId) {
        return reportRepository.findById(reportId)
                .orElseThrow(()-> ReportNotFoundException.EXCEPTION);
    }
}
