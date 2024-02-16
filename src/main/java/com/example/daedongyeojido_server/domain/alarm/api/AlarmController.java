package com.example.daedongyeojido_server.domain.alarm.api;

import com.example.daedongyeojido_server.domain.mess.application.AcceptMessService;
import com.example.daedongyeojido_server.domain.alarm.application.CreateAnnouncementService;
import com.example.daedongyeojido_server.domain.alarm.application.InterviewResultService;
import com.example.daedongyeojido_server.domain.alarm.application.MyAlarmService;
import com.example.daedongyeojido_server.domain.alarm.dto.request.CreateAnnouncementRequest;
import com.example.daedongyeojido_server.domain.alarm.dto.request.InterviewResultRequest;
import com.example.daedongyeojido_server.domain.alarm.dto.response.AlarmResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jung-ho/alarm")
public class AlarmController {

    private final CreateAnnouncementService createAnnouncementService;

    private final InterviewResultService interviewResultService;

    private final MyAlarmService myAlarmService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/announcement")
    public void createAnnouncement(@RequestBody @Valid CreateAnnouncementRequest request){
        createAnnouncementService.createAnnouncement(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/result")
    public void interviewResult(@RequestBody @Valid InterviewResultRequest request) {
        interviewResultService.interviewResult(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/my-alarm")
    public List<AlarmResponse> myAlarm() {
        return myAlarmService.myAlarm();
    }
}
