package com.example.daedongyeojido_server.domain.club.application;

import com.example.daedongyeojido_server.domain.club.dao.ClubRepository;
import com.example.daedongyeojido_server.domain.club.domain.Club;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteClubService {

    private final ClubRepository clubRepository;

    @Transactional
    public void deleteClub(String clubName) {
        Club club = clubRepository.findById(clubName)
                .orElseThrow(RuntimeException::new);
        clubRepository.delete(club);
    }
}