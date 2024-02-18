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
        String classNumber = getClassNumber(xquareUser);
        Part part = getPart(xquareUser);

        return userRepository.findByXquareId(request.getXquareId())
                .map(user -> jwtTokenProvider.receiveToken(request.getXquareId()))
                .orElseGet(() -> {
                    User user = createUser(request, xquareUser, classNumber, part);
                    userRepository.save(user);
                    return jwtTokenProvider.receiveToken(request.getXquareId());
                });
    }

    private String getClassNumber(XquareUserResponse xquareUser) {
        String num = xquareUser.getNum() < 10 ? "0" + xquareUser.getNum() : String.valueOf(xquareUser.getNum());
        return String.valueOf(xquareUser.getGrade()) + String.valueOf(xquareUser.getClass_num()) + num;
    }

    private Part getPart(XquareUserResponse xquareUser) {
        return "STU".equals(xquareUser.getUser_role()) ? Part.INDEPENDENT
                : "SCH".equals(xquareUser.getUser_role()) ? Part.TEACHER
                : Part.ERROR;
    }

    private User createUser(LoginRequest request, XquareUserResponse xquareUser, String classNumber, Part part) {
        User.UserBuilder userBuilder = User.builder()
                .xquareId(request.getXquareId())
                .name(xquareUser.getName());

        if ("신요셉".equals(xquareUser.getName())) {
            userBuilder.part(Part.CLUB_LEADER_TEACHER);
        } else {
            userBuilder.classNumber(classNumber).part(part);
        }

        return userBuilder.build();
    }
}
