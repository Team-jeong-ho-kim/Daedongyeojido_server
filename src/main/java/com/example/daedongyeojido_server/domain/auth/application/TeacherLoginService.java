package com.example.daedongyeojido_server.domain.auth.application;

import com.example.daedongyeojido_server.domain.auth.dto.request.TeacherLoginRequest;
import com.example.daedongyeojido_server.domain.auth.dto.response.LoginResponse;
import com.example.daedongyeojido_server.domain.user.dao.CustomUserRepository;
import com.example.daedongyeojido_server.domain.user.domain.User;
import com.example.daedongyeojido_server.domain.user.exception.UserNotFoundException;
import com.example.daedongyeojido_server.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherLoginService {

    private final CustomUserRepository customUserRepository;

    private final JwtTokenProvider jwtTokenProvider;

    public LoginResponse teacherLogin(TeacherLoginRequest request) {
        User user = customUserRepository.findTeacherByName(request.getName())
                .orElseThrow(()->UserNotFoundException.EXCEPTION);

        return jwtTokenProvider.receiveToken(request.getName());
    }
}
