package com.example.daedongyeojido_server.domain.club.api;

import com.example.daedongyeojido_server.domain.club.application.*;
import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.club.dto.request.CreateClubRequest;
import com.example.daedongyeojido_server.domain.club.dto.request.UpdateClubRequest;
import com.example.daedongyeojido_server.domain.club.dto.response.ClubInfoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/jung-ho/club")
@RestController
public class ClubController {

    private final CreateClubService createClubService;
    private final ModifyClubService modifyClubService;
    private final ClubInfoService clubInfoService;
    private final QueryAllClubService queryAllClubService;
    private final DeleteClubService deleteClubService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/create")
    public void createClub(@RequestBody @Valid CreateClubRequest request) {
        createClubService.createClub(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    public List<Club> queryAllClub() {
        return queryAllClubService.queryAllCLub();
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/detailed")
    public ClubInfoResponse clubInfo() {
        return clubInfoService.clubInfo();
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/update")
    public void modifyClub(@PathVariable String clubName,
                           @RequestBody @Valid UpdateClubRequest request) {
        modifyClubService.modifyClub(clubName, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete")
    public void deleteClub(@PathVariable String clubName) {
        deleteClubService.deleteClub(clubName);
    }
}