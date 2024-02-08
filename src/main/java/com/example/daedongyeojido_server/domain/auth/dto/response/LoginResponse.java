package com.example.daedongyeojido_server.domain.auth.dto.response;

import com.example.daedongyeojido_server.domain.user.domain.enums.Part;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class LoginResponse {
    private final String accessToken;

    private final String refreshToken;

    private final LocalDateTime expiredAt;

    private final Part part;
}