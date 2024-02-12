package com.example.daedongyeojido_server.domain.auth.dto.response;

import com.example.daedongyeojido_server.domain.user.domain.enums.Part;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class LoginResponse {

    private final String accessToken;

    private final String refreshToken;

    private Date accessExpiredAt;

    private Date refreshExpiredAt;

    private final Part part;
}