package com.example.daedongyeojido_server.domain.alarm.dto.request;

import com.example.daedongyeojido_server.domain.alarm.domain.enums.AlarmType;
import com.example.daedongyeojido_server.domain.report.domain.enums.PassingResult;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InterviewResultRequest {

    @NotNull
    private Long reportId;

    @NotNull
    private PassingResult passingResult;

    @NotNull
    private AlarmType alarmType;
}