package com.example.daedongyeojido_server.domain.auth.api;

import com.example.daedongyeojido_server.domain.auth.application.SignupService;
import com.example.daedongyeojido_server.domain.auth.application.StudentLoginService;
import com.example.daedongyeojido_server.domain.auth.application.TeacherLoginService;
import com.example.daedongyeojido_server.domain.auth.dto.request.SignupAndCheckUserRequest;
import com.example.daedongyeojido_server.domain.auth.dto.request.SignupRequest;
import com.example.daedongyeojido_server.domain.auth.dto.request.StudentLoginRequest;
import com.example.daedongyeojido_server.domain.auth.dto.request.TeacherLoginRequest;
import com.example.daedongyeojido_server.domain.auth.dto.response.TokenResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final SignupService signupService;

    private final StudentLoginService studentLoginService;

    private final TeacherLoginService teacherLoginService;

    @PostMapping("/signup")
    public void signup(@RequestBody @Valid SignupAndCheckUserRequest request) {
        signupService.signup(request);
    }

    @PostMapping("/student")
    public TokenResponse studentLogin(@RequestBody @Valid StudentLoginRequest request) {
        return studentLoginService.studentLogin(request);
    }

    @PostMapping("/teacher")
    public TokenResponse teacherLogin(@RequestBody @Valid TeacherLoginRequest request) {
        return teacherLoginService.teacherLogin(request);
    }

    @PostMapping("/check-user")
    public boolean checkUser(@RequestBody @Valid)
}
