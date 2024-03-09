package com.example.daedongyeojido_server.infra.feign.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class XquareUserRequest {

    @NotBlank
    private String accountId;

    @NotBlank
    private String password;
}
