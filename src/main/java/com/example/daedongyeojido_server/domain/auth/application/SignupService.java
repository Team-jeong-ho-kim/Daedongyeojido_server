package com.example.daedongyeojido_server.domain.auth.application;

import com.example.daedongyeojido_server.domain.auth.dto.request.SignupAndCheckUserRequest;
import com.example.daedongyeojido_server.domain.user.dao.UserRepository;
import com.example.daedongyeojido_server.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final UserRepository userRepository;

    public void signup(SignupAndCheckUserRequest request) {
        userRepository.save(
                User.builder()
                        .classNumber(request.getClassNumber())
                        .name(request.getName())
                        .part(request.getPart())
                        .build());
    }
}
