package com.example.daedongyeojido_server.domain.question.dao;

import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.question.domain.ClubQuest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<ClubQuest, Long> {
    List<ClubQuest> findAllByClub(Club club);
}
