package com.example.daedongyeojido_server.domain.club.application;

import com.example.daedongyeojido_server.domain.club.dao.ClubRepository;
import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.club.dto.request.CreateClubRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateClubService {

    private final ClubRepository clubRepository;

    public void createClub(CreateClubRequest request) {
        clubRepository.save(
                Club.builder()
                        .clubName(request.getClubName())
                        .build());
    }
}