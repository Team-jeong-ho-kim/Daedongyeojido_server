package com.example.daedongyeojido_server.domain.report.application;

import com.example.daedongyeojido_server.domain.club.exception.ClubMisMatchException;
import com.example.daedongyeojido_server.domain.report.application.facade.ReportFacade;
import com.example.daedongyeojido_server.domain.report.domain.Report;
import com.example.daedongyeojido_server.domain.report.dto.request.MemoRequest;
import com.example.daedongyeojido_server.domain.user.application.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ModifyMemoService {

    private final ReportFacade reportFacade;

    private final UserFacade userFacade;

    @Transactional
    public void modifyMemo(MemoRequest request) {
        Report report = reportFacade.reportFacade(request.getReportId());

        if(userFacade.currentUser().getMyClub() != report.getNotice().getClubName()) throw ClubMisMatchException.EXCEPTION;

        report.modifyMemo(request.getMemo());
    }
}