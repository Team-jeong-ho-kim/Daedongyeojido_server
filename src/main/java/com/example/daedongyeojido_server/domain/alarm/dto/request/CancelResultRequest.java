package com.example.daedongyeojido_server.domain.alarm.dto.request;

import com.example.daedongyeojido_server.domain.alarm.domain.enums.AlarmType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CancelResultRequest {

    @NotBlank
    private String clubName;

    @NotBlank
    private String classNumber;

    @NotNull
    private AlarmType alarmType;
}
