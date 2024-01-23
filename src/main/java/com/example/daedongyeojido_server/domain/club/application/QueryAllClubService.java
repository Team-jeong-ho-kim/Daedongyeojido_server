package com.example.daedongyeojido_server.domain.club.application;

import com.example.daedongyeojido_server.domain.club.dao.ClubRepository;
import com.example.daedongyeojido_server.domain.club.domain.Club;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QueryAllClubService {

    private final ClubRepository clubRepository;

    public List<Club> queryAllCLub() {
        return clubRepository.findAll();
    }
}