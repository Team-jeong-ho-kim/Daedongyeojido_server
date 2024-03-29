package com.example.daedongyeojido_server.domain.notice.application;

import com.example.daedongyeojido_server.domain.notice.dao.NoticeRepository;
import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import com.example.daedongyeojido_server.domain.notice.dto.response.ApplyPageResponse;
import com.example.daedongyeojido_server.domain.notice.dto.response.MajorResponse;
import com.example.daedongyeojido_server.domain.notice.dto.response.NoticeQuestResponse;
import com.example.daedongyeojido_server.domain.notice.exception.NoticeNotFoundException;
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
                .majors(notice.getFields().stream().map(MajorResponse::new).toList())
                .questions(notice.getNoticeQuests().stream().map(NoticeQuestResponse::new).toList())
                .build();
    }
}