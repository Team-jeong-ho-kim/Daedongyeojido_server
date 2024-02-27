package com.example.daedongyeojido_server.domain.announcement.api;

import com.example.daedongyeojido_server.domain.announcement.application.CreateAnnouncementService;
import com.example.daedongyeojido_server.domain.announcement.application.QueryAnnouncementService;
import com.example.daedongyeojido_server.domain.announcement.dto.request.CreateAnnouncementRequest;
import com.example.daedongyeojido_server.domain.announcement.dto.response.AnnouncementResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/announcement")
public class AnnouncementController {

    private final CreateAnnouncementService createAnnouncementService;

    private final QueryAnnouncementService queryAnnouncementService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void createAnnouncement(@RequestBody @Valid CreateAnnouncementRequest request) {
        createAnnouncementService.createAnnouncement(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/query")
    public List<AnnouncementResponse> queryAnnouncement() {
        return queryAnnouncementService.queryAnnouncement();
    }
}