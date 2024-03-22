package com.example.daedongyeojido_server.domain.report.application;

import com.example.daedongyeojido_server.domain.notice.application.facade.NoticeFacade;
import com.example.daedongyeojido_server.domain.notice.dao.NoticeQuestRepository;
import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import com.example.daedongyeojido_server.domain.notice.domain.NoticeQuest;
import com.example.daedongyeojido_server.domain.notice.exception.NoticeQuestNotFoundException;
import com.example.daedongyeojido_server.domain.report.dao.CustomReportRepository;
import com.example.daedongyeojido_server.domain.report.dao.ReportQuestRepository;
import com.example.daedongyeojido_server.domain.report.dao.ReportRepository;
import com.example.daedongyeojido_server.domain.report.domain.Report;
import com.example.daedongyeojido_server.domain.report.domain.ReportQuest;
import com.example.daedongyeojido_server.domain.report.domain.enums.PassingResult;
import com.example.daedongyeojido_server.domain.report.dto.request.ApplyRequest;
import com.example.daedongyeojido_server.domain.report.dto.request.ReportQuestRequest;
import com.example.daedongyeojido_server.domain.report.dto.request.SaveReportQuestRequest;
import com.example.daedongyeojido_server.domain.report.exception.AlreadyApplyUserException;
import com.example.daedongyeojido_server.domain.user.application.facade.UserFacade;
import com.example.daedongyeojido_server.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplyService {

    private final UserFacade userFacade;

    private final NoticeFacade noticeFacade;

    private final CustomReportRepository customReportRepository;

    private final ReportRepository reportRepository;

    private final NoticeQuestRepository noticeQuestRepository;

    private final ReportQuestRepository reportQuestRepository;

    @Transactional
    public void apply(ApplyRequest request) {
        User user = userFacade.currentUser();

        Notice notice = noticeFacade.noticeFacade(request.getNoticeId());

        if(!(customReportRepository.findClubReport(notice.getClubName()).isEmpty())) throw AlreadyApplyUserException.EXCEPTION;

        List<SaveReportQuestRequest> saveReportQuestRequests = new ArrayList<>();

        for(int i=0; i<request.getReportQuests().size(); i++) {
            ReportQuestRequest reportQuestRequest = request.getReportQuests().get(i);

            NoticeQuest noticeQuest = noticeQuestRepository.findById(reportQuestRequest.getNoticeQuestId())
                            .orElseThrow(()->NoticeQuestNotFoundException.EXCEPTION);

            saveReportQuestRequests.add(new SaveReportQuestRequest(noticeQuest.getQuestion(), reportQuestRequest.getAnswer()));
        }

        Report report = reportRepository.save(
                Report.builder()
                        .classNumber(user.getClassNumber())
                        .name(user.getName())
                        .introduce(request.getIntroduce())
                        .major(user.getMajor())
                        .reportQuests(saveReportQuestRequests.stream().map(ReportQuest::new).toList())
                        .reportPassingResult(PassingResult.WAIT)
                        .interviewPassingResult(PassingResult.WAIT)
                        .notice(notice)
                        .build());

        for(int i = 0;i<request.getReportQuests().size(); i++) {
            SaveReportQuestRequest saveReportQuestRequest = saveReportQuestRequests.get(i);

            reportQuestRepository.save(
                    ReportQuest.builder()
                            .question(saveReportQuestRequest.getQuestion())
                            .answer(saveReportQuestRequest.getAnswer())
                            .report(report)
                            .build());
        }
    }
}