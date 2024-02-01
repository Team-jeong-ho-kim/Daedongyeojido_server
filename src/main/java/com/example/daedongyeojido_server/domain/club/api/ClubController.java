package com.example.daedongyeojido_server.domain.club.api;

import com.example.daedongyeojido_server.domain.club.application.*;
import com.example.daedongyeojido_server.domain.club.dto.request.CreateClubRequest;
import com.example.daedongyeojido_server.domain.club.dto.request.ModifyClubRequest;
import com.example.daedongyeojido_server.domain.club.dto.response.ClubInfoResponse;
import com.example.daedongyeojido_server.domain.club.dto.response.QueryAllClubResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jung-ho/club")
public class ClubController {

    private final CreateClubService createClubService;

    private final ModifyClubService modifyClubService;

    private final ClubInfoService clubInfoService;

    private final QueryAllClubService queryAllClubService;

    private final DeleteClubService deleteClubService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void createClub(@RequestBody @Valid CreateClubRequest request) {
        createClubService.createClub(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/info")
    public ClubInfoResponse clubInfo() {
        return clubInfoService.clubInfo();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    public List<QueryAllClubResponse> queryAllClub() {
        return queryAllClubService.queryAllClub();
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/modify/{clubName}")
    public void modifyClub(@PathVariable String clubName,
                           @RequestBody @Valid ModifyClubRequest request) {
        modifyClubService.modifyClub(clubName, request);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{clubName}")
    public void deleteClub(@PathVariable String clubName) {
        deleteClubService.deleteClub(clubName);
    }
}