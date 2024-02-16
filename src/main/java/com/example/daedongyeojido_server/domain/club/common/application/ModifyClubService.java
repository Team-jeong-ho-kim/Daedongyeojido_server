package com.example.daedongyeojido_server.domain.club.common.application;

import com.example.daedongyeojido_server.domain.club.common.dao.ClubRepository;
import com.example.daedongyeojido_server.domain.club.common.domain.Club;
import com.example.daedongyeojido_server.domain.club.common.dto.request.ModifyClubRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ModifyClubService {

    private final ClubRepository clubRepository;

    @Transactional
    public void modifyClub(ModifyClubRequest request) {
        Club club = clubRepository.findByClubName(request.getClubName());

        club.modifyClub(request.getTitle(), request.getIntroduction(), request.getProject(), request.getWeWant(), request.getQAndA(), request.getClubImageUrl());
    }
}