package com.example.daedongyeojido_server.domain.club.application;

import com.example.daedongyeojido_server.domain.club.dao.ClubRepository;
import com.example.daedongyeojido_server.domain.club.dto.response.QueryAllClubResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryAllClubService {

    private final ClubRepository clubRepository;

    @Transactional
    public List<QueryAllClubResponse> queryAllClub() {

        return clubRepository.findAll()
                .stream()
                .map(QueryAllClubResponse::new)
                .collect(Collectors.toList());
    }
}