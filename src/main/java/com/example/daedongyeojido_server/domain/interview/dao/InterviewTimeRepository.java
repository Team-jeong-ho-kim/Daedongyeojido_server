package com.example.daedongyeojido_server.domain.interview.dao;

import com.example.daedongyeojido_server.domain.interview.domain.InterviewTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterviewTimeRepository extends JpaRepository<InterviewTime, Long> {
    List<InterviewTime> findAllByClubName(String clubName);

    void deleteAllByClubName(String clubName);
}