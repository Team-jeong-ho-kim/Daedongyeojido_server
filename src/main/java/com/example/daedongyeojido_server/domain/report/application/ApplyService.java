package com.example.daedongyeojido_server.domain.report.application;

import com.example.daedongyeojido_server.domain.notice.application.facade.NoticeFacade;
import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import com.example.daedongyeojido_server.domain.report.dao.CustomReportRepository;
import com.example.daedongyeojido_server.domain.report.dao.ReportRepository;
import com.example.daedongyeojido_server.domain.report.domain.Report;
import com.example.daedongyeojido_server.domain.report.domain.ReportQuest;
import com.example.daedongyeojido_server.domain.report.dto.request.ApplyRequest;
import com.example.daedongyeojido_server.domain.report.dto.request.ReportQuestRequest;
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

    private final NoticeFacade noticeFacade;

    private final CustomReportRepository customReportRepository;

    private final ReportRepository reportRepository;

    @Transactional
    public void apply(ApplyRequest request) {
        User user = userFacade.currentUser();

        Notice notice = noticeFacade.noticeFacade(request.getNoticeId());

        if(!(customReportRepository.findClubReport(notice.getClubName()).isEmpty())) throw AlreadyApplyUserException.EXCEPTION;

        Report report = reportRepository.save(
                Report.builder()
                        .classNumber(user.getClassNumber())
                        .name(user.getName())
                        .introduce(request.getIntroduce())
                        .notice(notice)
                        .build());

        for(int i=0; i<request.getReportQuests().size(); i++) {
               ReportQuestRequest reportQuestRequest = request.getReportQuests().get(i);

               ReportQuest reportQuest = ReportQuest.builder()
                       .question(reportQuestRequest.getQuestion())
                       .answer(reportQuestRequest.getAnswer())
                       .report(report)
                       .build();

               report.addReportQuest(reportQuest);
        }
    }
}