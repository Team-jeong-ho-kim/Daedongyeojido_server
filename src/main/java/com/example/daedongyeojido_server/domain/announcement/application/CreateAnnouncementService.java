package com.example.daedongyeojido_server.domain.announcement.application;

import com.example.daedongyeojido_server.domain.announcement.dao.AnnouncementRepository;
import com.example.daedongyeojido_server.domain.announcement.domain.Announcement;
import com.example.daedongyeojido_server.domain.announcement.dto.request.CreateAnnouncementRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CreateAnnouncementService {

    private final AnnouncementRepository announcementRepository;

    @Transactional
    public void createAnnouncement(CreateAnnouncementRequest request) {
        announcementRepository.save(
                Announcement.builder()
                        .title(request.getTitle())
                        .contents(request.getContents())
                        .createTime(LocalDateTime.now())
                        .build());
    }
}