package com.example.daedongyeojido_server.domain.club.admin.application;

import com.example.daedongyeojido_server.domain.club.dao.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteClubService {

    private final ClubRepository clubRepository;

    @Transactional
    public void deleteClub(String clubName) {
        clubRepository.deleteById(clubName);
    }
}