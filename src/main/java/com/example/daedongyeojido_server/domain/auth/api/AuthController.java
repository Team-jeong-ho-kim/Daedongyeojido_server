package com.example.daedongyeojido_server.domain.auth.api;

import com.example.daedongyeojido_server.domain.auth.application.StudentLoginService;
import com.example.daedongyeojido_server.domain.auth.dto.request.StudentLoginRequest;
import com.example.daedongyeojido_server.domain.auth.dto.response.TokenResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final StudentLoginService studentLoginService;

    @PostMapping("/student")
    public TokenResponse studentLogin(@RequestBody @Valid StudentLoginRequest request) {
        return studentLoginService.studentLogin(request);
    }
//
//    @PostMapping("/teacher")
//    public TokenResponse studentLogin(@RequestBody @Valid StudentLoginRequest request) {
//        return studentLoginService.studentLogin(request);
//    }
}
