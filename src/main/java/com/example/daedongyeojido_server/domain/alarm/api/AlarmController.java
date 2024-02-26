package com.example.daedongyeojido_server.domain.alarm.api;

import com.example.daedongyeojido_server.domain.alarm.application.MyAlarmService;
import com.example.daedongyeojido_server.domain.alarm.application.ReportResultService;
import com.example.daedongyeojido_server.domain.alarm.dto.request.ReportResultRequest;
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

    private final ReportResultService reportResultService;

    private final MyAlarmService myAlarmService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/result")
    public void interviewResult(@RequestBody @Valid ReportResultRequest request) {
        reportResultService.reportResult(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/my-alarm")
    public List<AlarmResponse> myAlarm() {
        return myAlarmService.myAlarm();
    }
}