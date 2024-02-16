package com.example.daedongyeojido_server.domain.club.common.api;

import com.example.daedongyeojido_server.domain.club.common.application.AddTagService;
import com.example.daedongyeojido_server.domain.club.common.application.ClubInfoService;
import com.example.daedongyeojido_server.domain.club.common.application.CreateClubService;
import com.example.daedongyeojido_server.domain.club.common.application.DeleteClubService;
import com.example.daedongyeojido_server.domain.club.common.application.ModifyClubService;
import com.example.daedongyeojido_server.domain.club.common.application.QueryClubListService;
import com.example.daedongyeojido_server.domain.club.common.dto.request.CreateClubRequest;
import com.example.daedongyeojido_server.domain.club.common.dto.request.ModifyClubRequest;
import com.example.daedongyeojido_server.domain.club.common.dto.request.TagRequest;
import com.example.daedongyeojido_server.domain.club.common.dto.response.ClubInfoResponse;
import com.example.daedongyeojido_server.domain.club.common.dto.response.ClubListResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jung-ho/club")
public class ClubController {

    private final CreateClubService createClubService;

    private final AddTagService addTagService;

    private final QueryClubListService queryClubListService;

    private final ModifyClubService modifyClubService;

    private final ClubInfoService clubInfoService;

    private final DeleteClubService deleteClubService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void createClub(@RequestBody @Valid CreateClubRequest request) {
        createClubService.createClub(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/tag")
    public void addTag(@RequestBody @Valid TagRequest request) {
        addTagService.addTag(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/all")
    public List<ClubListResponse> queryClubList() {
        return queryClubListService.queryClubList();
    }

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

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{clubName}")
    public void deleteClub(@PathVariable String clubName) {
        deleteClubService.deleteClub(clubName);
    }
}