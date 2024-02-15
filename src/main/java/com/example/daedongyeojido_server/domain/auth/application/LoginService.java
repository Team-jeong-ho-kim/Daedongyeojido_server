package com.example.daedongyeojido_server.domain.auth.application;

import com.example.daedongyeojido_server.domain.auth.dto.request.LoginRequest;
import com.example.daedongyeojido_server.domain.auth.dto.response.LoginResponse;
import com.example.daedongyeojido_server.domain.user.dao.CustomUserRepository;
import com.example.daedongyeojido_server.domain.user.dao.UserRepository;
import com.example.daedongyeojido_server.domain.user.domain.User;
import com.example.daedongyeojido_server.domain.user.domain.enums.Part;
import com.example.daedongyeojido_server.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    private final CustomUserRepository customUserRepository;

    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public LoginResponse login(LoginRequest request) {

        if(userRepository.findByXquareId(request.getXquareId()).isPresent()) {
            return jwtTokenProvider.receiveToken(request.getXquareId());
        }
        else if (request.getName().equals("신요셉")) {
            User user = User.builder()
                    .name(request.getName())
                    .part(Part.CLUB_LEADER_TEACHER)
                    .build();

            userRepository.save(user);
        }
        else {
            User user = User.builder()
                    .xquareId(request.getXquareId())
                    .classNumber(request.getClassNumber())
                    .name(request.getName())
                    .part(request.getPart())
                    .build();

            userRepository.save(user);
        }

        return jwtTokenProvider.receiveToken(request.getXquareId());
    }
}
