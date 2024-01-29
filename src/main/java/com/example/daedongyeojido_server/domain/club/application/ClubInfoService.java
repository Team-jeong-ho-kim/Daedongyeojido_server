package com.example.daedongyeojido_server.domain.club.application;

import com.example.daedongyeojido_server.domain.club.dao.ClubRepository;
import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.club.dto.response.ClubInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClubInfoService {

    private final ClubRepository clubRepository;

    @Transactional
    public ClubInfoResponse clubInfo() {

        Club club = clubRepository.findByClubName(clubInfo().getClubName());

        return ClubInfoResponse.builder()
                .clubName(club.getClubName())
                .title(club.getTitle())
                .contents(club.getContent())
                .clubImageUrl(club.getClubImageUrl())
                .tags(club.getTags())
                .clubMembers(club.getClubMembers())
                .build();
    }
}