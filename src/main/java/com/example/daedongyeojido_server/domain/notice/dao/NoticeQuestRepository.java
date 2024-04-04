package com.example.daedongyeojido_server.domain.notice.dao;

import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import com.example.daedongyeojido_server.domain.notice.domain.NoticeQuest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticeQuestRepository extends JpaRepository<NoticeQuest, Long> {
    List<NoticeQuest> findAllByNotice(Notice notice);
}
