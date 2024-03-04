package com.example.daedongyeojido_server.domain.report.application;

import com.example.daedongyeojido_server.domain.club.exception.ClubMisMatchException;
import com.example.daedongyeojido_server.domain.report.dao.ReportRepository;
import com.example.daedongyeojido_server.domain.report.domain.Report;
import com.example.daedongyeojido_server.domain.report.dto.response.MemoResponse;
import com.example.daedongyeojido_server.domain.report.exception.ReportNotFoundException;
import com.example.daedongyeojido_server.domain.user.application.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QueryMemoService {

    private final ReportRepository reportRepository;

    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public MemoResponse queryMemo(Long reportId) {
        Report report = reportRepository.findById(reportId)
                .orElseThrow(()-> ReportNotFoundException.EXCEPTION);

        if(userFacade.currentUser().getMyClub() != report.getNotice().getClubName()) throw ClubMisMatchException.EXCEPTION;

        return MemoResponse.builder()
                .classNumber(report.getClassNumber())
                .name(report.getName())
                .major(report.getNotice().getMajor())
                .interviewPassingResult(report.getInterviewPassingResult())
                .memo(report.getMemo())
                .build();
    }
}
