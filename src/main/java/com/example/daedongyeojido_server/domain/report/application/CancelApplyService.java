package com.example.daedongyeojido_server.domain.report.application;

import com.example.daedongyeojido_server.domain.report.application.facade.ReportFacade;
import com.example.daedongyeojido_server.domain.report.dao.ReportRepository;
import com.example.daedongyeojido_server.domain.report.domain.Report;
import com.example.daedongyeojido_server.domain.user.application.facade.UserFacade;
import com.example.daedongyeojido_server.domain.user.exception.UserMismatchException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CancelApplyService {

    private final ReportFacade reportFacade;

    private final UserFacade userFacade;

    private final ReportRepository reportRepository;

    @Transactional
    public void cancelApply(Long reportId) {
        Report report = reportFacade.reportFacade(reportId);

        if(!userFacade.currentUser().getClassNumber().equals(report.getClassNumber())) throw UserMismatchException.EXCEPTION;

        reportRepository.delete(report);
    }
}