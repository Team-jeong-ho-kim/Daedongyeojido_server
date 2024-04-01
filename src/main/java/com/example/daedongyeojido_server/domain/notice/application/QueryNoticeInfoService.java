package com.example.daedongyeojido_server.domain.notice.application;

import com.example.daedongyeojido_server.domain.notice.application.facade.NoticeFacade;
import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import com.example.daedongyeojido_server.domain.notice.dto.response.FieldResponse;
import com.example.daedongyeojido_server.domain.notice.dto.response.NoticeInfoResponse;
import com.example.daedongyeojido_server.domain.notice.dto.response.StartAndEndTimeResponse;
import com.example.daedongyeojido_server.domain.report.dao.CustomReportRepository;
import com.example.daedongyeojido_server.domain.user.application.facade.UserFacade;
import com.example.daedongyeojido_server.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QueryNoticeInfoService {

    private final NoticeFacade noticeFacade;

    private final UserFacade userFacade;

    private final CustomReportRepository customReportRepository;

    @Transactional(readOnly = true)
    public NoticeInfoResponse queryNoticeInfo(Long noticeId) {
        Notice notice = noticeFacade.noticeFacade(noticeId);

        User user = userFacade.currentUser();

        return NoticeInfoResponse.builder()
                .isApply((customReportRepository.findByClassNumber(user.getClassNumber()) == null) ? false : true)
                .clubName(notice.getClubName().getClubName())
                .noticeTitle(notice.getNoticeTitle())
                .noticeExplain(notice.getNoticeExplain())
                .clubExplain(notice.getClubExplain())
                .fields(notice.getFields().stream().map(FieldResponse::new).toList())
                .recruitDay(new StartAndEndTimeResponse(notice.getRecruitDay().getStartDay(), notice.getRecruitDay().getEndDay()))
                .applyMethod(notice.getApplyMethod())
                .interviewDay(new StartAndEndTimeResponse(notice.getInterviewDay().getStartDay(), notice.getInterviewDay().getEndDay()))
                .inquiry(notice.getInquiry())
                .weWant(notice.getWeWant())
                .assignment(notice.getAssignment())
                .build();
    }
}