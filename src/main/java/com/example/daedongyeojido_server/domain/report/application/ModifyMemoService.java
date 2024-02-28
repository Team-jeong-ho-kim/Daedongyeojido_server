package com.example.daedongyeojido_server.domain.report.application;

import com.example.daedongyeojido_server.domain.club.common.exception.ClubMisMatchException;
import com.example.daedongyeojido_server.domain.report.dao.ReportRepository;
import com.example.daedongyeojido_server.domain.report.domain.Report;
import com.example.daedongyeojido_server.domain.report.dto.request.MemoRequest;
import com.example.daedongyeojido_server.domain.report.exception.ReportNotFoundException;
import com.example.daedongyeojido_server.domain.user.application.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ModifyMemoService {

    private final UserFacade userFacade;

    private final ReportRepository reportRepository;

    @Transactional
    public void modifyMemo(MemoRequest request) {
        Report report = reportRepository.findById(request.getReportId())
                .orElseThrow(() -> ReportNotFoundException.EXCEPTION);

        if (!(userFacade.currentUser().getMyClub().equals(report.getNotice().getClubName()))) {
            throw ClubMisMatchException.EXCEPTION;
        }

        report.modifyMemo(request.getMemo());
    }
}