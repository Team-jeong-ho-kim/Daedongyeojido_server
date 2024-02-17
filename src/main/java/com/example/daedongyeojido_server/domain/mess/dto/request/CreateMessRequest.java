package com.example.daedongyeojido_server.domain.mess.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateMessRequest {

    @Min(1)
    @Max(10)
    @NotNull
    private Integer messStartTime;

    @Min(1)
    @Max(10)
    @NotNull
    private Integer messEndTime;

    @NotNull
    private LocalDate messDate;
}