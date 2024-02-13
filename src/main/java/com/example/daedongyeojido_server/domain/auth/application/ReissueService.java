package com.example.daedongyeojido_server.domain.auth.application;

import com.example.daedongyeojido_server.domain.auth.dao.RefreshTokenRepository;
import com.example.daedongyeojido_server.domain.auth.domain.RefreshToken;
import com.example.daedongyeojido_server.domain.auth.dto.response.LoginResponse;
import com.example.daedongyeojido_server.domain.auth.exception.InvaildRefreshTokenException;
import com.example.daedongyeojido_server.domain.auth.exception.RefreshTokenNotFoundException;
import com.example.daedongyeojido_server.global.security.jwt.JwtProperties;
import com.example.daedongyeojido_server.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReissueService {

    private final JwtTokenProvider jwtTokenProvider;

    private final JwtProperties jwtProperties;

    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public LoginResponse reissue(String refreshToken) {
        String parseToken = jwtTokenProvider.parseToken(refreshToken);

        if (parseToken == null) {
            throw InvaildRefreshTokenException.EXCEPTION;
        }

        RefreshToken redisRefreshToken = refreshTokenRepository.findByToken(jwtTokenProvider.parseToken(refreshToken))
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        String newRefreshToken = jwtTokenProvider.createRefreshToken(redisRefreshToken.getClassNumber());
        redisRefreshToken.updateToken(newRefreshToken, jwtProperties.getRefreshExpiration());

        String newAccessToken = jwtTokenProvider.createAccessToken(redisRefreshToken.getClassNumber());

        return LoginResponse.builder()
                .accessToken(newAccessToken)
                .refreshToken(newRefreshToken)
                .build();
    }
}