package com.example.daedongyeojido_server.domain.auth.application;

import com.example.daedongyeojido_server.domain.auth.dto.request.SignupAndCheckUserRequest;
import com.example.daedongyeojido_server.domain.user.dao.CustomUserRepository;
import com.example.daedongyeojido_server.domain.user.dao.UserRepository;
import com.example.daedongyeojido_server.domain.user.domain.enums.Part;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckUserService {

    private final UserRepository userRepository;

    private final CustomUserRepository customUserRepository;

    public boolean checkUser(SignupAndCheckUserRequest request) {
        if (request.getPart() == Part.INDEPENDENT) {
            return userRepository.findByClassNumber(request.getClassNumber()).isPresent();
        }
        else {
            return customUserRepository.findTeacherByName(request.getName()).isPresent();
        }
    }
}
