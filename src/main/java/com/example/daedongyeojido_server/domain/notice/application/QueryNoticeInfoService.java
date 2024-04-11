package com.example.daedongyeojido_server.domain.notice.application;

import com.example.daedongyeojido_server.domain.notice.application.facade.NoticeFacade;
import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import com.example.daedongyeojido_server.domain.notice.dto.response.FieldResponse;
import com.example.daedongyeojido_server.domain.notice.dto.response.NoticeInfoResponse;
import com.example.daedongyeojido_server.domain.notice.dto.response.StartAndEndTimeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QueryNoticeInfoService {

    private final NoticeFacade noticeFacade;

    @Transactional(readOnly = true)
    public NoticeInfoResponse queryNoticeInfo(Long noticeId) {
        Notice notice = noticeFacade.noticeFacade(noticeId);

        return NoticeInfoResponse.builder()
                .clubName(notice.getClubName().getClubName())
                .noticeTitle(notice.getNoticeTitle1())
                .noticeExplain(notice.getNoticeExplain1())
                .clubExplain(notice.getClubExplain1())
                .fields(notice.getFields().stream().map(FieldResponse::new).toList())
                .recruitDay(new StartAndEndTimeResponse(notice.getRecruitDay().getStartDay(), notice.getRecruitDay().getEndDay()))
                .applyMethod(notice.getApplyMethod1())
                .interviewDay(new StartAndEndTimeResponse(notice.getInterviewDay().getStartDay(), notice.getInterviewDay().getEndDay()))
                .inquiry(notice.getInquiry1())
                .weWant(notice.getWeWant1())
                .assignment(notice.getAssignment1())
                .build();
    }
}