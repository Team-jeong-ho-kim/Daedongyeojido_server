package com.example.daedongyeojido_server.domain.alarm.dto.request;

import com.example.daedongyeojido_server.domain.alarm.domain.enums.PassOrNot;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InterviewResultRequest {

    @NotBlank
    private Long alarmId;

    @NotBlank
    @Size(min = 1, max = 20, message = "제목은 1글자 이상, 20글자 이하여야 합니다, 또한 작성하지 않으면 안됩니다.")
    private String title;

    private PassOrNot passOrNot;

    @NotBlank
    @Size(min = 1, max = 20, message = "clubname은 1글자 이상, 20글자 이하여야 합니다.")
    private String clubName;

    @NotBlank
    @Size(min = 2, max = 4)
    private String userName;
}