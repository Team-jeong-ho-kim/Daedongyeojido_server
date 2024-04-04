package com.example.daedongyeojido_server.domain.notice.application;

import com.example.daedongyeojido_server.domain.notice.application.facade.NoticeFacade;
import com.example.daedongyeojido_server.domain.notice.dao.NoticeQuestRepository;
import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import com.example.daedongyeojido_server.domain.notice.dto.response.NoticeQuestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryAllNoticeQuestService {

    private final NoticeFacade noticeFacade;

    private final NoticeQuestRepository noticeQuestRepository;

    @Transactional(readOnly = true)
    public List<NoticeQuestResponse> queryAllNoticeQuest(Long noticeId) {
        Notice notice = noticeFacade.noticeFacade(noticeId);

        return noticeQuestRepository.findAllByNotice(notice)
                .stream()
                .map(NoticeQuestResponse::new)
                .collect(Collectors.toList());
    }
}
