package com.example.daedongyeojido_server.domain.interview.dto.response;

import com.example.daedongyeojido_server.domain.interview.domain.InterviewTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class InterviewTimeResponse {

    private Long interviewTimeId;

    private LocalDateTime interviewStartTime;

    private LocalDateTime interviewEndTime;

    public InterviewTimeResponse(InterviewTime interviewTime) {
        interviewTimeId = interviewTime.getInterviewTimeId();
        interviewStartTime = interviewTime.getInterviewStartTime();
        interviewEndTime = interviewTime.getInterviewEndTime();
    }
}
