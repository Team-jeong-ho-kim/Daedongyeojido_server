package com.example.daedongyeojido_server.domain.notice.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StartAndEndTimeRequest {

    @NotNull
    private LocalDate startDay;

    @NotNull
    private LocalDate endDay;
}
