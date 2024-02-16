package com.example.daedongyeojido_server.domain.mess.dao;

import com.example.daedongyeojido_server.domain.club.common.domain.Club;
import com.example.daedongyeojido_server.domain.mess.domain.Mess;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MessRepository extends JpaRepository<Mess, Long> {
    Optional<Mess> findByMyClub(Club myClub);
}