package com.example.daedongyeojido_server.domain.notice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class StartAndEndTimeResponse {

    private LocalDate startDay;

    private LocalDate endDay;
}
