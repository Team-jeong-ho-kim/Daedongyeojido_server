package com.example.daedongyeojido_server.domain.auth.application;

import com.example.daedongyeojido_server.domain.auth.dto.request.StudentLoginRequest;
import com.example.daedongyeojido_server.domain.auth.dto.response.TokenResponse;
import com.example.daedongyeojido_server.domain.user.dao.UserRepository;
import com.example.daedongyeojido_server.domain.user.domain.User;
import com.example.daedongyeojido_server.domain.user.exception.UserNotFoundException;
import com.example.daedongyeojido_server.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentLoginService {

    private final UserRepository userRepository;

    private final JwtTokenProvider jwtTokenProvider;

    public TokenResponse studentLogin(StudentLoginRequest request) {
        User user = userRepository.findByClassNumber(request.getClassNumber())
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        return jwtTokenProvider.receiveToken(request.getClassNumber());
    }
}
