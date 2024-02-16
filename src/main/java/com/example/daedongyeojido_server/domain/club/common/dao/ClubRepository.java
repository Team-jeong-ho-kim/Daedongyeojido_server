package com.example.daedongyeojido_server.domain.club.common.dao;

import com.example.daedongyeojido_server.domain.club.common.domain.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, String> {
    Club findByClubName(String clubName);
}