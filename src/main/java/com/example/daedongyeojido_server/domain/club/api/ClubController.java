package com.example.daedongyeojido_server.domain.club.api;

import com.example.daedongyeojido_server.domain.club.application.CreateClubService;
import com.example.daedongyeojido_server.domain.club.dto.request.CreateClubRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/club")
public class ClubController {

    private final CreateClubService createClubService;

    @PostMapping()
    public void createClub(@RequestBody @Valid CreateClubRequest request) {
        createClubService.createClub(request);
    }
}
