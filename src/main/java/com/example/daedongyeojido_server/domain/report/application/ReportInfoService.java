package com.example.daedongyeojido_server.domain.report.application;

import com.example.daedongyeojido_server.domain.club.exception.ClubMisMatchException;
import com.example.daedongyeojido_server.domain.report.application.facade.ReportFacade;
import com.example.daedongyeojido_server.domain.report.domain.Report;
import com.example.daedongyeojido_server.domain.report.dto.response.ReportInfoResponse;
import com.example.daedongyeojido_server.domain.report.dto.response.ReportQuestResponse;
import com.example.daedongyeojido_server.domain.user.application.facade.UserFacade;
import com.example.daedongyeojido_server.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReportInfoService {

    private final ReportFacade reportFacade;

    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public ReportInfoResponse reportInfo(Long reportId) {
        Report report = reportFacade.reportFacade(reportId);

        User user = userFacade.currentUser();

        if(user.getMyClub() != report.getNotice().getClubName()) throw ClubMisMatchException.EXCEPTION;

        return ReportInfoResponse.builder()
                .classNumber(report.getClassNumber())
                .name(report.getName())
                .introduce(report.getIntroduce())
                .reportPassingResult(report.getReportPassingResult())
                .noticeQuests(report.getReportQuests().stream().map(ReportQuestResponse::new).toList())
                .build();
    }
}