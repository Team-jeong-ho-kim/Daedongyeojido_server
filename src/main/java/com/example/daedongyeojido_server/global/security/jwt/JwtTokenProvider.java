package com.example.daedongyeojido_server.global.security.jwt;

import com.example.daedongyeojido_server.domain.auth.dao.RefreshTokenRepository;
import com.example.daedongyeojido_server.domain.auth.domain.RefreshToken;
import com.example.daedongyeojido_server.domain.auth.dto.response.LoginResponse;
import com.example.daedongyeojido_server.domain.auth.exception.ExpiredTokenException;
import com.example.daedongyeojido_server.domain.auth.exception.InvalidTokenException;
import com.example.daedongyeojido_server.domain.user.dao.CustomUserRepository;
import com.example.daedongyeojido_server.domain.user.dao.UserRepository;
import com.example.daedongyeojido_server.domain.user.domain.User;
import com.example.daedongyeojido_server.domain.user.exception.UserNotFoundException;
import com.example.daedongyeojido_server.global.security.auth.CustomUserDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final JwtProperties jwtProperties;

    private final UserRepository userRepository;

    private final CustomUserRepository customUserRepository;

    private final CustomUserDetailsService customUserDetailsService;

    private final RefreshTokenRepository refreshTokenRepository;

    // access token 생성

    public String createAccessToken(String classNumber) {

        Date now = new Date();

        return Jwts.builder()
                .setSubject(classNumber)
                .claim("type", "access")
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + jwtProperties.getAccessExpiration() * 1000))
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecret())
                .compact();
    }

    public String createRefreshToken(String classNumber) {

        Date now = new Date();

        String refreshToken = Jwts.builder()
                .claim("type", "refresh")
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + jwtProperties.getRefreshExpiration() * 1000))
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecret())
                .compact();

        refreshTokenRepository.save(
                RefreshToken.builder()
                        .classNumber(classNumber)
                        .token(refreshToken)
                        .timeToLive(jwtProperties.getRefreshExpiration())
                        .build());

        return refreshToken;
    }

    // 토큰에 담겨있는 userId로 SpringSecurity Authentication 정보를 반환하는 메서드
    public Authentication getAuthentication(String token) {
        Claims claims = getClaims(token);
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(claims.getSubject());
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private Claims getClaims(String token) {
        try {
            return Jwts
                    .parser()
                    .setSigningKey(jwtProperties.getSecret())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw ExpiredTokenException.EXCEPTION;
        } catch (Exception e) {
            throw InvalidTokenException.EXCEPTION;
        }
    }

    public LoginResponse receiveToken(String classNumber) {

        User user = userRepository.findByClassNumber(classNumber)
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        return LoginResponse
                .builder()
                .accessToken(createAccessToken(classNumber))
                .refreshToken(createRefreshToken(classNumber))
                .part(user.getPart())
                .build();
    }

    public LoginResponse teacherReceiveToken(String name) {

        User user = customUserRepository.findTeacherByName(name)
                .orElseThrow(()->UserNotFoundException.EXCEPTION);

        return LoginResponse
                .builder()
                .accessToken(createAccessToken(name))
                .refreshToken(createRefreshToken(name))
                .part(user.getPart())
                .build();
    }

    // HTTP 요청 헤더에서 토큰을 가져오는 메서드
    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(jwtProperties.getHeader());

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(jwtProperties.getPrefix())
                && bearerToken.length() > jwtProperties.getPrefix().length() + 1) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
