package com.example.daedongyeojido_server.domain.notice.application.facade;

import com.example.daedongyeojido_server.domain.notice.dao.NoticeRepository;
import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import com.example.daedongyeojido_server.domain.notice.exception.NoticeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NoticeFacade {

    private final NoticeRepository noticeRepository;

    public Notice noticeFacade(Long noticeId) {
        return noticeRepository.findById(noticeId)
                .orElseThrow(()-> NoticeNotFoundException.EXCEPTION);
    }
}
