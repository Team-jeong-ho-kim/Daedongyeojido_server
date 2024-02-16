package com.example.daedongyeojido_server.domain.club.admin.application;

import com.example.daedongyeojido_server.domain.club.admin.dto.response.AdminPageResponse;
import com.example.daedongyeojido_server.domain.club.common.dao.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryAdminPageService {

    private final ClubRepository clubRepository;

    @Transactional
    public List<AdminPageResponse> queryAdminPage() {
        return clubRepository.findAll()
                .stream()
                .map(AdminPageResponse::new)
                .collect(Collectors.toList());
    }
}
