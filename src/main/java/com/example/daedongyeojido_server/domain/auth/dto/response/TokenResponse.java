package com.example.daedongyeojido_server.domain.auth.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenResponse {
    String accessToken;
    String refreshToken;
}