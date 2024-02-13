package com.example.daedongyeojido_server.domain.club.application;

import com.example.daedongyeojido_server.domain.club.dao.ClubRepository;
import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.club.dto.request.TagRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AddTagService {

    private final ClubRepository clubRepository;

    @Transactional
    public void addTag(TagRequest request) {
        Club club = clubRepository.findByClubName(request.getClubName());

        club.addTag(request.getTag());
    }
}
