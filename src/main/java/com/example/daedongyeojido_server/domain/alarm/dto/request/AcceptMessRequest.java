package com.example.daedongyeojido_server.domain.alarm.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AcceptMessRequest {

    @NotNull
    private Long messId;
}
