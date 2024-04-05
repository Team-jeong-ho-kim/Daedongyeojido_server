package com.example.daedongyeojido_server.domain.auth.application;

import com.example.daedongyeojido_server.domain.auth.dto.request.LoginRequest;
import com.example.daedongyeojido_server.domain.auth.dto.response.LoginResponse;
import com.example.daedongyeojido_server.domain.club.dao.ClubRepository;
import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.notice.domain.enums.Major;
import com.example.daedongyeojido_server.domain.user.dao.UserRepository;
import com.example.daedongyeojido_server.domain.user.domain.User;
import com.example.daedongyeojido_server.domain.user.domain.enums.Part;
import com.example.daedongyeojido_server.domain.user.exception.PasswordMismatchException;
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

    private final ClubRepository clubRepository;

    private final XquareClient xquareClient;

    private final PasswordEncoder passwordEncoder;

    @Value("${key.admin-id}")
    private String adminId;

    @Value("${key.reverie-id}")
    private String reverieId;

    @Transactional
    public LoginResponse login(LoginRequest request) {
        if(userRepository.existsByAccountId(request.getAccount_id())) {
            User user = userRepository.findByAccountId(request.getAccount_id())
                    .orElseThrow(()-> UserNotFoundException.EXCEPTION);

            if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) throw PasswordMismatchException.EXCEPTION;

            return jwtTokenProvider.receiveToken(request.getAccount_id());
        }

        if(request.getAccount_id().equals(adminId)) {
            userRepository.save(User.builder()
                    .userId("admin")
                    .accountId(request.getAccount_id())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .name("관리자")
                    .major(Major.UNDEFINED)
                    .part(Part.ADMIN)
                    .build());

            return jwtTokenProvider.receiveToken(request.getAccount_id());
        }

        if(request.getAccount_id().equals(reverieId)) {
            userRepository.save(User.builder()
                    .userId("reverie")
                    .accountId(request.getAccount_id())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .name("래벨리")
                    .major(Major.UNDEFINED)
                    .part(Part.REVERIE)
                    .build());

            return jwtTokenProvider.receiveToken(request.getAccount_id());
        }

        XquareUserResponse xquareUserResponse = xquareClient.xquareUser(request.getAccount_id(), request.getPassword());

        String num = xquareUserResponse.getNum()<10 ? '0' + Integer.toString(xquareUserResponse.getNum()) : Integer.toString(xquareUserResponse.getNum());
        String classNumber = xquareUserResponse.getGrade().toString() + xquareUserResponse.getClass_num().toString() + num;

        Club club = clubRepository.findByClubName(xquareUserResponse.getClubName());

        userRepository.save(
                User.builder()
                    .userId(xquareUserResponse.getId().toString())
                    .accountId(xquareUserResponse.getAccount_id())
                    .password(xquareUserResponse.getPassword())
                    .name(xquareUserResponse.getName())
                    .classNumber(classNumber)
                    .major(Major.UNDEFINED)
                    .part(xquareUserResponse.getUser_role().equals("STU") ? Part.INDEPENDENT : Part.TEACHER)
                    .profileImageUrl(xquareUserResponse.getProfileImgUrl())
                    .myClub(club)
                    .build());

        return jwtTokenProvider.receiveToken(xquareUserResponse.getAccount_id());
    }
}