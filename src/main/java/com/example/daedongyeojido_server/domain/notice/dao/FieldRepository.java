package com.example.daedongyeojido_server.domain.notice.dao;

import com.example.daedongyeojido_server.domain.notice.domain.Field;
import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FieldRepository extends JpaRepository<Field, Long> {
    void deleteAllByNotice(Notice notice);
}
