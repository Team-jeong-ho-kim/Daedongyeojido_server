package com.example.daedongyeojido_server.domain.club.common.application;

import com.example.daedongyeojido_server.domain.club.common.dao.ClubRepository;
import com.example.daedongyeojido_server.domain.club.common.dto.response.ClubListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryClubListService {

    private final ClubRepository clubRepository;

    @Transactional
    public List<ClubListResponse> queryClubList() {
        return clubRepository.findAll()
                .stream()
                .map(ClubListResponse::new)
                .collect(Collectors.toList());
    }
}
