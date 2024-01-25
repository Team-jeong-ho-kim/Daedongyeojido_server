package com.example.daedongyeojido_server.domain.mess.dao;

import com.example.daedongyeojido_server.domain.mess.domain.Mess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessRepository extends JpaRepository<Mess, Long> {
}