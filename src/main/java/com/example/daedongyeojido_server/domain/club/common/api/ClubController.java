package com.example.daedongyeojido_server.domain.club.common.api;

import com.example.daedongyeojido_server.domain.club.common.application.ChooseInterviewTimeService;
import com.example.daedongyeojido_server.domain.club.common.application.ClubInfoService;
import com.example.daedongyeojido_server.domain.club.common.application.ModifyClubService;
import com.example.daedongyeojido_server.domain.club.common.application.QueryInterviewTimeService;
import com.example.daedongyeojido_server.domain.club.common.domain.InterviewTime;
import com.example.daedongyeojido_server.domain.club.common.dto.request.InterviewTimeRequest;
import com.example.daedongyeojido_server.domain.club.common.dto.request.ModifyClubRequest;
import com.example.daedongyeojido_server.domain.club.common.dto.response.ClubInfoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/club")
public class ClubController {

    private final ChooseInterviewTimeService chooseInterviewTImeService;

    private final ClubInfoService clubInfoService;

    private final QueryInterviewTimeService queryInterviewTimeService;

    private final ModifyClubService modifyClubService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/choose-interview-time")
    public void chooseInterviewTime(@RequestBody @Valid InterviewTimeRequest request) {
        chooseInterviewTImeService.chooseInterviewTime(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/info/{clubName}")
    public ClubInfoResponse clubInfo(@PathVariable String clubName) {
        return clubInfoService.clubInfo(clubName);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/query-interview-time/{reportId}")
    public List<InterviewTime> queryInterviewTime(@PathVariable Long reportId) {
        return queryInterviewTimeService.queryInterviewTime(reportId);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/modify")
    public void modifyClub(@RequestBody @Valid ModifyClubRequest request) {
        modifyClubService.modifyClub(request);
    }
}