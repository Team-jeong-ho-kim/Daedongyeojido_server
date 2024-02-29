package com.example.daedongyeojido_server.domain.notice.application;

import com.example.daedongyeojido_server.domain.notice.dao.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteNoticeService {

    private final NoticeRepository noticeRepository;

    @Transactional
    public void deleteNotice(Long noticeId) {
        noticeRepository.deleteById(noticeId);
    }
}