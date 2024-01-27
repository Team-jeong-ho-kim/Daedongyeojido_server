package com.example.daedongyeojido_server.domain.mess.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateMessRequest {

    @NotBlank
    private Long messId;

    @NotBlank
    @Size(min = 1, max = 2, message = "시작 교시는 한 자리수 또는 두 자리수 안으로 선택해야하며 선택을 하지 않으면 안됩니다.")
    private Integer messStartTime;

    @NotBlank
    @Size(min = 1, max = 2, message = "마무리 교시는 한 자리수 또는 두 자리수 안으로 선택해야하며 선택을 하지 않으면 안됩니다.")
    private Integer messEndTime;

    @NotBlank
    private LocalDate messDate;
}