package com.example.daedongyeojido_server.domain.notice.application;

import com.example.daedongyeojido_server.domain.notice.dao.NoticeQuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteNoticeQuestService {

    private final NoticeQuestRepository noticeQuestRepository;

    @Transactional
    public void deleteNoticeQuest(Long noticeQuestId) {
        noticeQuestRepository.deleteById(noticeQuestId);
    }
}
