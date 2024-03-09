package com.example.daedongyeojido_server.domain.auth.application;

import com.example.daedongyeojido_server.domain.auth.dto.request.LoginRequest;
import com.example.daedongyeojido_server.domain.auth.dto.response.LoginResponse;
import com.example.daedongyeojido_server.domain.user.dao.UserRepository;
import com.example.daedongyeojido_server.domain.user.domain.User;
import com.example.daedongyeojido_server.domain.user.domain.enums.Part;
import com.example.daedongyeojido_server.domain.user.exception.PasswordMisMatchException;
import com.example.daedongyeojido_server.domain.user.exception.UserNotFoundException;
import com.example.daedongyeojido_server.global.security.jwt.JwtTokenProvider;
import com.example.daedongyeojido_server.infra.feign.XquareClient;
import com.example.daedongyeojido_server.infra.feign.dto.response.XquareUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    private final JwtTokenProvider jwtTokenProvider;

    private final XquareClient xquareClient;

    private final PasswordEncoder passwordEncoder;

    @Value("${key.admin-id}")
    private String adminId;

    @Transactional
    public LoginResponse login(LoginRequest request) {
        if(request.getPassword().equals(adminId)) {
            User.builder()
                    .accountId(request.getAccount_id())
                    .name("관리자")
                    .part(Part.ADMIN)
                    .build();

            return jwtTokenProvider.receiveToken(request.getAccount_id());
        }

        XquareUserResponse xquareUserResponse = xquareClient.xquareUser(request.getAccount_id(), request.getPassword());

        if(userRepository.existsByUserId(xquareUserResponse.getId().toString())) {
            User user = userRepository.findByAccountId(request.getAccount_id())
                    .orElseThrow(()-> UserNotFoundException.EXCEPTION);

            if(!passwordEncoder.matches(xquareUserResponse.getPassword(), user.getPassword())) throw PasswordMisMatchException.EXCEPTION;

            return jwtTokenProvider.receiveToken(request.getAccount_id());
        }

        else {
            String num = xquareUserResponse.getNum()<10 ? '0' + Integer.toString(xquareUserResponse.getNum()) : Integer.toString(xquareUserResponse.getNum());
            String classNumber = xquareUserResponse.getGrade().toString() + xquareUserResponse.getClass_num().toString() + num;

            userRepository.save(
                    User.builder()
                    .userId(xquareUserResponse.getId().toString())
                    .accountId(xquareUserResponse.getAccount_id())
                    .password(xquareUserResponse.getPassword())
                    .name(xquareUserResponse.getName())
                    .classNumber(classNumber)
                    .part(xquareUserResponse.getUser_role().equals("STU") ? Part.INDEPENDENT : Part.TEACHER)
                    .build());

            return jwtTokenProvider.receiveToken(xquareUserResponse.getAccount_id());
        }
    }
}