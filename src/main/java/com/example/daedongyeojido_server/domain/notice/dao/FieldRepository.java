package com.example.daedongyeojido_server.domain.notice.dao;

import com.example.daedongyeojido_server.domain.notice.domain.Field;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FieldRepository extends JpaRepository<Field, Long> {
}
