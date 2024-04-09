package com.example.daedongyeojido_server.domain.alarm.api;

import com.example.daedongyeojido_server.domain.alarm.application.CancelResultService;
import com.example.daedongyeojido_server.domain.alarm.application.InterviewResultService;
import com.example.daedongyeojido_server.domain.alarm.application.MyAlarmService;
import com.example.daedongyeojido_server.domain.alarm.dto.request.CancelResultRequest;
import com.example.daedongyeojido_server.domain.alarm.dto.request.InterviewResultRequest;
import com.example.daedongyeojido_server.domain.alarm.dto.response.AlarmResponse;
import com.example.daedongyeojido_server.domain.alarm.dto.response.ReportIdResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/alarm")
public class AlarmController {

    private final InterviewResultService interviewResultService;

    private final MyAlarmService myAlarmService;

    private final CancelResultService cancelResultService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/interview-result")
    public ReportIdResponse interviewResult(@RequestBody @Valid InterviewResultRequest request) {
        return interviewResultService.interviewResult(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/my-alarm")
    public List<AlarmResponse> myAlarm() {
        return myAlarmService.myAlarm();
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/cancel")
    public void cancelResult(@RequestBody @Valid CancelResultRequest request) {
        cancelResultService.cancelResult(request);
    }
}