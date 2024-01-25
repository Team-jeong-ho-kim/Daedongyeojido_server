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
    @Size(max = 2)
    private Integer messStartTime;

    @NotBlank
    @Size(max = 2)
    private Integer messEndTime;

//    @NotBlank
//    private Boolean messAgree;

    @NotBlank
    private LocalDate messDate;
}