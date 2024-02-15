package com.example.daedongyeojido_server.domain.mess.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateMessRequest {

    @NotNull
    private Integer messStartTime;

    @NotNull
    private Integer messEndTime;

    @NotNull
    private LocalDate messDate;
}