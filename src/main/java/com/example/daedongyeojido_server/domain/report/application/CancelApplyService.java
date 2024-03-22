package com.example.daedongyeojido_server.domain.report.application;

import com.example.daedongyeojido_server.domain.report.dao.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CancelApplyService {

    private final ReportRepository reportRepository;

    @Transactional
    public void cancelApply(Long reportId) {
        reportRepository.deleteById(reportId);
    }
}