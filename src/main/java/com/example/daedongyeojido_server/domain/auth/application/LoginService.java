package com.example.daedongyeojido_server.domain.auth.application;

import com.example.daedongyeojido_server.domain.auth.dto.request.LoginRequest;
import com.example.daedongyeojido_server.domain.auth.dto.response.LoginResponse;
import com.example.daedongyeojido_server.domain.user.dao.UserRepository;
import com.example.daedongyeojido_server.domain.user.domain.User;
import com.example.daedongyeojido_server.domain.user.domain.enums.Part;
import com.example.daedongyeojido_server.global.security.jwt.JwtTokenProvider;
import com.example.daedongyeojido_server.infra.feign.XquareClient;
import com.example.daedongyeojido_server.infra.feign.dto.response.XquareUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    private final JwtTokenProvider jwtTokenProvider;

    private final XquareClient xquareClient;

    @Transactional
    public LoginResponse login(LoginRequest request) {

        XquareUserResponse xquareUser = xquareClient.xquareUser(request.getXquareId());

        String num = "null";
        if(xquareUser.getNum()<10) num = "0" + String.valueOf(xquareUser.getNum());

        String classNumber = String.valueOf(xquareUser.getGrade()) + String.valueOf(xquareUser.getClass_num()) + num;

        Part part = Part.ERROR;
        if(xquareUser.getUser_role().equals("STU")) part = Part.INDEPENDENT;
        else if (xquareUser.getUser_role().equals("SCH")) part = Part.TEACHER;

        if(userRepository.findByXquareId(request.getXquareId()).isPresent()) {
            return jwtTokenProvider.receiveToken(request.getXquareId());
        }
        else if (xquareUser.getName().equals("신요셉")) {
            User user = User.builder()
                    .xquareId(request.getXquareId())
                    .name(xquareUser.getName())
                    .part(Part.CLUB_LEADER_TEACHER)
                    .build();

            userRepository.save(user);
        }
        else {
            User user = User.builder()
                    .xquareId(request.getXquareId())
                    .classNumber(classNumber)
                    .name(xquareUser.getName())
                    .part(part)
                    .build();

            userRepository.save(user);
        }

        return jwtTokenProvider.receiveToken(request.getXquareId());
    }
}
