package com.example.daedongyeojido_server.domain.club.application;

import com.example.daedongyeojido_server.domain.club.dao.ClubRepository;
import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.club.dto.request.CreateClubRequest;
import com.example.daedongyeojido_server.domain.club.exception.ExistClubException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateClubService {

    private final ClubRepository clubRepository;

    @Transactional
    public void createClub(CreateClubRequest request) {

        if (clubRepository.existsById(request.getClubName()))
            throw ExistClubException.EXCEPTION;

        clubRepository.save(
                Club.builder()
                        .clubName(request.getClubName())
                        .build());
    }
}