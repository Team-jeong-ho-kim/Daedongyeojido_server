package com.example.daedongyeojido_server.domain.club.common.api;

import com.example.daedongyeojido_server.domain.club.common.application.ClubInfoService;
import com.example.daedongyeojido_server.domain.club.common.application.ModifyClubService;
import com.example.daedongyeojido_server.domain.club.common.dto.request.ModifyClubRequest;
import com.example.daedongyeojido_server.domain.club.common.dto.response.ClubInfoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/club")
public class ClubController {

    private final ModifyClubService modifyClubService;

    private final ClubInfoService clubInfoService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/info/{clubName}")
    public ClubInfoResponse clubInfo(@PathVariable String clubName) {
        return clubInfoService.clubInfo(clubName);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/modify")
    public void modifyClub(@RequestBody @Valid ModifyClubRequest request) {
        modifyClubService.modifyClub(request);
    }
}