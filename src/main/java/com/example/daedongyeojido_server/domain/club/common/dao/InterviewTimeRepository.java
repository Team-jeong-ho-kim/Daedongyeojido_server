package com.example.daedongyeojido_server.domain.club.common.dao;

import com.example.daedongyeojido_server.domain.club.common.domain.InterviewTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterviewTimeRepository extends JpaRepository<InterviewTime, Long> {
    List<InterviewTime> findAllByClubName(String clubName);
}
