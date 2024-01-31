package com.example.daedongyeojido_server.domain.club.dao;

import com.example.daedongyeojido_server.domain.club.domain.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubRepository extends JpaRepository<Club, String> {
    Club findByClubName(String clubName);

    List<Club> findAllByClubName(Club club);
}