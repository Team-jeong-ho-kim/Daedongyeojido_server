package com.example.daedongyeojido_server.domain.notice.dao;

import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import com.example.daedongyeojido_server.domain.notice.domain.StartAndEndTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StartEndEndTimeRepository extends JpaRepository<StartAndEndTime, Long> {
    void deleteAllByNotice(Notice notice);
}
