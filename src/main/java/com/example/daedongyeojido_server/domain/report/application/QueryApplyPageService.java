package com.example.daedongyeojido_server.domain.report.application;

import com.example.daedongyeojido_server.domain.notice.dao.NoticeRepository;
import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import com.example.daedongyeojido_server.domain.notice.exception.NoticeNotFoundException;
import com.example.daedongyeojido_server.domain.report.dto.response.ApplyPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QueryApplyPageService {

    private final NoticeRepository noticeRepository;

    @Transactional(readOnly = true)
    public ApplyPageResponse queryApplyPage(Long noticeId) {
        Notice notice = noticeRepository.findById(noticeId)
                .orElseThrow(() -> NoticeNotFoundException.EXCEPTION);

        return ApplyPageResponse.builder()
                .clubName(notice.getClubName().getClubName())
                .major(notice.getMajor())
                .build();
    }
}