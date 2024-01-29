package com.example.daedongyeojido_server.domain.alarm.api;

import com.example.daedongyeojido_server.domain.alarm.application.CreateAnnouncementService;
import com.example.daedongyeojido_server.domain.alarm.dto.request.CreateAnnouncementRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jung-ho/alarm")
public class AlarmController {

    private final CreateAnnouncementService createAnnouncementService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/announcement")
    public void createAnnouncement(@RequestBody @Valid CreateAnnouncementRequest request){
        createAnnouncementService.createAnnouncement(request);
    }
}