package com.example.daedongyeojido_server.domain.report.application;

import com.example.daedongyeojido_server.domain.notice.dao.NoticeRepository;
import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import com.example.daedongyeojido_server.domain.notice.exception.NoticeNotFoundException;
import com.example.daedongyeojido_server.domain.report.dto.response.ApplyPageResponse;
import com.example.daedongyeojido_server.domain.report.dto.response.QuestionResponse;
import com.example.daedongyeojido_server.domain.user.application.facade.UserFacade;
import com.example.daedongyeojido_server.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QueryApplyPageService {

    private final UserFacade userFacade;

    private final NoticeRepository noticeRepository;

    @Transactional(readOnly = true)
    public ApplyPageResponse queryApplyPage(Long noticeId) {
        User user = userFacade.currentUser();

        Notice notice = noticeRepository.findById(noticeId)
                .orElseThrow(() -> NoticeNotFoundException.EXCEPTION);

        return ApplyPageResponse.builder()
                .name(user.getName())
                .classNumber(user.getClassNumber())
                .questions(notice.getReportQuests().stream().map(QuestionResponse::new).toList())
                .build();
    }
}