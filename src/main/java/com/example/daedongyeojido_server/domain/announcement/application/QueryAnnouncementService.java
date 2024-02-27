package com.example.daedongyeojido_server.domain.announcement.application;

import com.example.daedongyeojido_server.domain.announcement.dao.AnnouncementRepository;
import com.example.daedongyeojido_server.domain.announcement.dto.response.AnnouncementResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryAnnouncementService {

    private final AnnouncementRepository announcementRepository;

    public List<AnnouncementResponse> queryAnnouncement() {
        return announcementRepository.findAll()
                .stream()
                .map(AnnouncementResponse::new)
                .collect(Collectors.toList());
    }
}