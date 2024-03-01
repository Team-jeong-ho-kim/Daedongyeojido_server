package com.example.daedongyeojido_server.domain.interview.api;

import com.example.daedongyeojido_server.domain.interview.application.ChooseInterviewTimeService;
import com.example.daedongyeojido_server.domain.interview.application.ModifyInterviewTimeService;
import com.example.daedongyeojido_server.domain.interview.application.QueryInterviewTimeService;
import com.example.daedongyeojido_server.domain.interview.dto.request.ChooseInterviewRequest;
import com.example.daedongyeojido_server.domain.interview.dto.request.InterviewTimeRequest;
import com.example.daedongyeojido_server.domain.interview.dto.response.InterviewTimeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/interview")
public class InterviewController {

    private final ChooseInterviewTimeService chooseInterviewTImeService;

    private final QueryInterviewTimeService queryInterviewTimeService;

    private final ModifyInterviewTimeService modifyInterviewTimeService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/choose-time")
    public void chooseInterviewTime(@RequestBody @Valid ChooseInterviewRequest request) {
        chooseInterviewTImeService.chooseInterviewTime(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/query-time/{reportId}")
    public List<InterviewTimeResponse> queryInterviewTime(@PathVariable Long reportId) {
        return queryInterviewTimeService.queryInterviewTime(reportId);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/modify-time/{clubName}")
    public void modifyInterviewTime(@PathVariable String clubName, @RequestBody @Valid List<InterviewTimeRequest> requests) {
        modifyInterviewTimeService.modifyInterviewTime(clubName, requests);
    }
}