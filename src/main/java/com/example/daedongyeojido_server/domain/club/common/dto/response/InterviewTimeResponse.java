package com.example.daedongyeojido_server.domain.club.common.dto.response;

import com.example.daedongyeojido_server.domain.club.common.domain.InterviewTime;
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
