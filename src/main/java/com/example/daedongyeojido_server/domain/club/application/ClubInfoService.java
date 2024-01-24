package com.example.daedongyeojido_server.domain.club.application;

import com.example.daedongyeojido_server.domain.club.dao.ClubRepository;
import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.club.dto.response.ClubInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ClubInfoService {

    private final ClubRepository clubRepository;

    @Transactional
    public ClubInfoResponse clubInfo() {

        Club club = clubRepository.findByClubName(clubInfo().getClubName());

        return ClubInfoResponse.builder()
                .clubName(club.getClubName())
                .build();
    }
}