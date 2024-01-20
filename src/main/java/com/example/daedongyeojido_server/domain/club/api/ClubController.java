package com.example.daedongyeojido_server.domain.club.api;

import com.example.daedongyeojido_server.domain.club.application.CreateClubService;
import com.example.daedongyeojido_server.domain.club.application.QueryAllClubService;
import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.club.dto.request.CreateClubRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jung-ho/club")
public class ClubController {

    private final CreateClubService createClubService;

    private final QueryAllClubService queryAllClubService;

    @PostMapping()
    public void createClub(@RequestBody @Valid CreateClubRequest request) {
        createClubService.createClub(request);
    }

    @GetMapping("/all")
    public List<Club> queryAllClub() {
        return queryAllClubService.queryAllCLub();
    }
}
