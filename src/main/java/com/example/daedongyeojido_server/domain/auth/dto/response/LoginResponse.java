package com.example.daedongyeojido_server.domain.auth.dto.response;

import com.example.daedongyeojido_server.domain.user.domain.enums.Part;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponse {
    String accessToken;

    String refreshToken;

    Part part;
}