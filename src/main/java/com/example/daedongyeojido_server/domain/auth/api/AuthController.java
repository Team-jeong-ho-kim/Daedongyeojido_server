package com.example.daedongyeojido_server.domain.auth.api;

import com.example.daedongyeojido_server.domain.auth.application.CheckUserService;
import com.example.daedongyeojido_server.domain.auth.application.LoginService;
import com.example.daedongyeojido_server.domain.auth.application.SignupService;
import com.example.daedongyeojido_server.domain.auth.application.StudentLoginService;
import com.example.daedongyeojido_server.domain.auth.application.TeacherLoginService;
import com.example.daedongyeojido_server.domain.auth.dto.request.SignupAndCheckUserRequest;
import com.example.daedongyeojido_server.domain.auth.dto.request.StudentLoginRequest;
import com.example.daedongyeojido_server.domain.auth.dto.request.TeacherLoginRequest;
import com.example.daedongyeojido_server.domain.auth.dto.response.LoginResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jung-ho/auth")
public class AuthController {

    private final LoginService loginService;

    private final SignupService signupService;

    private final StudentLoginService studentLoginService;

    private final TeacherLoginService teacherLoginService;

    private final CheckUserService checkUserService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Valid SignupAndCheckUserRequest request) {
        return loginService.login(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signup(@RequestBody @Valid SignupAndCheckUserRequest request) {
        signupService.signup(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/student")
    public LoginResponse studentLogin(@RequestBody @Valid StudentLoginRequest request) {
        return studentLoginService.studentLogin(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/teacher")
    public LoginResponse teacherLogin(@RequestBody @Valid TeacherLoginRequest request) {
        return teacherLoginService.teacherLogin(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/check-user")
    public boolean checkUser(@RequestBody @Valid SignupAndCheckUserRequest request) {
        return checkUserService.checkUser(request);
    }
}
