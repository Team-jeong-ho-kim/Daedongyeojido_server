package com.example.daedongyeojido_server.domain.notice.application;

import com.example.daedongyeojido_server.domain.notice.application.facade.NoticeFacade;
import com.example.daedongyeojido_server.domain.notice.dao.NoticeQuestRepository;
import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import com.example.daedongyeojido_server.domain.notice.domain.NoticeQuest;
import com.example.daedongyeojido_server.domain.notice.dto.request.NoticeQuestRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AddNoticeQuestService {

    private final NoticeFacade noticeFacade;

    private final NoticeQuestRepository noticeQuestRepository;

    @Transactional
    public void addNoticeQuest(NoticeQuestRequest request) {
        Notice notice = noticeFacade.noticeFacade(request.getNoticeId());

        NoticeQuest noticeQuest = NoticeQuest.builder()
                .question(request.getQuestion())
                .notice(notice)
                .build();

        noticeQuestRepository.save(noticeQuest);
        notice.addQuest(noticeQuest);
    }
}
