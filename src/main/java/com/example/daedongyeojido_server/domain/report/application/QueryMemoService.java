package com.example.daedongyeojido_server.domain.report.application;

import com.example.daedongyeojido_server.domain.club.exception.ClubMisMatchException;
import com.example.daedongyeojido_server.domain.report.application.facade.ReportFacade;
import com.example.daedongyeojido_server.domain.report.domain.Report;
import com.example.daedongyeojido_server.domain.report.dto.response.MemoResponse;
import com.example.daedongyeojido_server.domain.user.application.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QueryMemoService {

    private final ReportFacade reportFacade;

    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public MemoResponse queryMemo(Long reportId) {
        Report report = reportFacade.reportFacade(reportId);

        if(userFacade.currentUser().getMyClub() != report.getNotice().getClubName()) throw ClubMisMatchException.EXCEPTION;

        return MemoResponse.builder()
                .classNumber(report.getClassNumber())
                .name(report.getName())
                .interviewPassingResult(report.getInterviewPassingResult())
                .memo(report.getMemo())
                .build();
    }
}
