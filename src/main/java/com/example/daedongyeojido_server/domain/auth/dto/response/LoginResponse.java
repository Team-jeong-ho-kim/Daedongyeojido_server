package com.example.daedongyeojido_server.domain.auth.dto.response;

import com.example.daedongyeojido_server.domain.user.domain.enums.Part;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class LoginResponse {

    private String accessToken;

    private String refreshToken;

    private Date accessExpiredAt;

    private Date refreshExpiredAt;

    private Part part;
}