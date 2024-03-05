package com.example.daedongyeojido_server.domain.report.application;

import com.example.daedongyeojido_server.domain.notice.dao.NoticeRepository;
import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import com.example.daedongyeojido_server.domain.notice.exception.NoticeNotFoundException;
import com.example.daedongyeojido_server.domain.report.dao.CustomReportRepository;
import com.example.daedongyeojido_server.domain.report.dao.ReportRepository;
import com.example.daedongyeojido_server.domain.report.domain.Report;
import com.example.daedongyeojido_server.domain.report.domain.enums.PassingResult;
import com.example.daedongyeojido_server.domain.report.dto.request.ApplyRequest;
import com.example.daedongyeojido_server.domain.report.exception.AlreadyApplyUserException;
import com.example.daedongyeojido_server.domain.user.application.facade.UserFacade;
import com.example.daedongyeojido_server.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ApplyService {

    private final UserFacade userFacade;

    private final NoticeRepository noticeRepository;

    private final CustomReportRepository customReportRepository;

    private final ReportRepository reportRepository;

    @Transactional
    public void apply(ApplyRequest request) {
        User user = userFacade.currentUser();

        Notice notice = noticeRepository.findById(request.getNoticeId())
                .orElseThrow(() -> NoticeNotFoundException.EXCEPTION);

        if(!(customReportRepository.findClubReport(notice.getClubName()).isEmpty())) throw AlreadyApplyUserException.EXCEPTION;

        reportRepository.save(
                Report.builder()
                        .classNumber(user.getClassNumber())
                        .name(user.getName())
                        .oneLiner(request.getOneLiner())
                        .introduction(request.getIntroduction())
                        .hopeMajor(request.getHopeMajor())
                        .learn(request.getLearn())
                        .reportPassingResult(PassingResult.WAIT)
                        .interviewPassingResult(PassingResult.WAIT)
                        .notice(notice)
                        .build());
    }
}