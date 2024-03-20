package com.example.daedongyeojido_server.domain.notice.application;

import com.example.daedongyeojido_server.domain.notice.application.facade.NoticeFacade;
import com.example.daedongyeojido_server.domain.notice.dao.FieldRepository;
import com.example.daedongyeojido_server.domain.notice.dao.NoticeRepository;
import com.example.daedongyeojido_server.domain.notice.dao.StartEndEndTimeRepository;
import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteNoticeService {

    private final NoticeFacade noticeFacade;

    private final NoticeRepository noticeRepository;

    private final FieldRepository fieldRepository;

    private final StartEndEndTimeRepository startEndEndTimeRepository;

    @Transactional
    public void deleteNotice(Long noticeId) {
        Notice notice = noticeFacade.noticeFacade(noticeId);

        fieldRepository.deleteAllByNotice(notice);
        startEndEndTimeRepository.deleteAllByNotice(notice);
        noticeRepository.deleteById(noticeId);
    }
}