package com.example.daedongyeojido_server.domain.club.admin.api;

import com.example.daedongyeojido_server.domain.club.admin.application.CreateClubService;
import com.example.daedongyeojido_server.domain.club.admin.application.DeleteClubService;
import com.example.daedongyeojido_server.domain.club.admin.application.QueryAdminPageService;
import com.example.daedongyeojido_server.domain.club.admin.dto.request.CreateClubRequest;
import com.example.daedongyeojido_server.domain.club.admin.dto.response.AdminPageResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jung-ho/admin-club")
public class AdminClubController {

    private final CreateClubService createClubService;

    private final QueryAdminPageService queryAdminPageService;

    private final DeleteClubService deleteClubService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void createClub(@RequestBody @Valid CreateClubRequest request) {
        createClubService.createClub(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/all")
    public List<AdminPageResponse> queryClubList() {
        return queryAdminPageService.queryAdminPage();
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{clubName}")
    public void deleteClub(@PathVariable String clubName) {
        deleteClubService.deleteClub(clubName);
    }
}
