package com.example.daedongyeojido_server.domain.notice.dao;

import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
    Notice findByNoticeTitle(String noticeTitle);
    Boolean existsByNoticeTitle(String noticeTitle);
}