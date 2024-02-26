package com.example.daedongyeojido_server.domain.alarm.api;

import com.example.daedongyeojido_server.domain.alarm.application.InterviewResultService;
import com.example.daedongyeojido_server.domain.alarm.application.MyAlarmService;
import com.example.daedongyeojido_server.domain.alarm.dto.request.InterviewResultRequest;
import com.example.daedongyeojido_server.domain.alarm.dto.response.AlarmResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/alarm")
public class AlarmController {

    private final InterviewResultService interviewResultService;

    private final MyAlarmService myAlarmService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/interview-result")
    public void interviewResult(@RequestBody @Valid InterviewResultRequest request) {
        interviewResultService.interviewResult(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/my-alarm")
    public List<AlarmResponse> myAlarm() {
        return myAlarmService.myAlarm();
    }
}