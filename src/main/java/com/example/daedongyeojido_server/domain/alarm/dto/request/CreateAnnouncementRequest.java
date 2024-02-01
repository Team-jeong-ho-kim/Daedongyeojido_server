package com.example.daedongyeojido_server.domain.alarm.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateAnnouncementRequest {

    @NotNull
    private Long alarmId;

    @NotBlank
    @Size(min = 1, max = 20, message = "제목은 1글자 이상, 20글자 이하여야 합니다, 또한 작성하지 않으면 안됩니다.")
    private String title;

    @NotBlank
    @Size(min = 1, max = 200, message = "내용은 1글자 이상, 200글자 이하여야 합니다.")
    private String contents;
}