package com.example.daedongyeojido_server.domain.club.common.application;

import com.example.daedongyeojido_server.domain.club.dao.ClubRepository;
import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.club.common.dto.request.ModifyClubRequest;
import com.example.daedongyeojido_server.domain.club.exception.ClubMisMatchException;
import com.example.daedongyeojido_server.domain.user.application.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ModifyClubService {

    private final UserFacade userFacade;

    private final ClubRepository clubRepository;

    @Transactional
    public void modifyClub(ModifyClubRequest request) {
        if(!(userFacade.currentUser().getMyClub().getClubName().equals(request.getClubName()))) throw ClubMisMatchException.EXCEPTION;

        Club club = clubRepository.findByClubName(request.getClubName());

        club.modifyClub(request.getTitle(), request.getIntroduction(), request.getProject(),
                request.getWeWant(), request.getQAndA(), request.getClubImageUrl(), request.getTags());
    }
}
