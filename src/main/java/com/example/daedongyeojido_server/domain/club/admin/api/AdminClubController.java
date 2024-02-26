package com.example.daedongyeojido_server.domain.club.admin.api;

import com.example.daedongyeojido_server.domain.club.admin.application.CreateClubService;
import com.example.daedongyeojido_server.domain.club.admin.application.DeleteClubService;
import com.example.daedongyeojido_server.domain.club.admin.application.EditClubMemberService;
import com.example.daedongyeojido_server.domain.club.admin.application.QueryAdminPageService;
import com.example.daedongyeojido_server.domain.club.admin.dto.request.CreateClubRequest;
import com.example.daedongyeojido_server.domain.club.admin.dto.request.EditClubMemberRequest;
import com.example.daedongyeojido_server.domain.club.admin.dto.response.AdminPageResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin-club")
public class AdminClubController {

    private final CreateClubService createClubService;

    private final QueryAdminPageService queryAdminPageService;

    private final EditClubMemberService editClubMemberService;

    private final DeleteClubService deleteClubService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void createClub(@RequestBody @Valid CreateClubRequest request) {
        createClubService.createClub(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/page")
    public List<AdminPageResponse> queryClubList() {
        return queryAdminPageService.queryAdminPage();
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/edit-member")
    public void editClub(@RequestBody @Valid EditClubMemberRequest request) {
        editClubMemberService.editClubMember(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{clubName}")
    public void deleteClub(@PathVariable String clubName) {
        deleteClubService.deleteClub(clubName);
    }
}