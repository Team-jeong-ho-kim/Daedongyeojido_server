package com.example.daedongyeojido_server.domain.user.application;

import com.example.daedongyeojido_server.domain.club.common.dao.ClubRepository;
import com.example.daedongyeojido_server.domain.club.common.domain.Club;
import com.example.daedongyeojido_server.domain.user.dao.UserRepository;
import com.example.daedongyeojido_server.domain.user.domain.User;
import com.example.daedongyeojido_server.domain.user.dto.request.AddClubMemberRequest;
import com.example.daedongyeojido_server.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AddClubMemberService {

    private final UserRepository userRepository;

    private final ClubRepository clubRepository;

    @Transactional
    public void AddClubMember(AddClubMemberRequest request) {
        User user = userRepository.findByClassNumber(request.getClassNumber())
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        Club club = clubRepository.findByClubName(request.getClubName());

        club.addMember(user);

        user.addClubMember(request.getName(), request.getPart(), club);
    }
}
