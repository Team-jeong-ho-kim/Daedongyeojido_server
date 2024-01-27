package com.example.daedongyeojido_server.domain.notice.dto.request;

import com.example.daedongyeojido_server.domain.notice.domain.enums.Major;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateNoticeRequest {

    private Major major;

    @NotBlank
    @Size(min = 1, max = 20, message = "clubName은 1글자 이상, 20글자 이하여야 합니다.")
    private String clubName;

    private LocalDateTime deadline;
}
