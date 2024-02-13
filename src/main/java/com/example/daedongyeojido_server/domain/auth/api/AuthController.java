package com.example.daedongyeojido_server.domain.auth.api;

import com.example.daedongyeojido_server.domain.auth.application.LoginService;
import com.example.daedongyeojido_server.domain.auth.application.ReissueService;
import com.example.daedongyeojido_server.domain.auth.dto.request.LoginRequest;
import com.example.daedongyeojido_server.domain.auth.dto.request.RefreshTokenRequest;
import com.example.daedongyeojido_server.domain.auth.dto.response.LoginResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jung-ho/auth")
public class AuthController {

    private final LoginService loginService;

    private final ReissueService reissueService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Valid LoginRequest request) {
        return loginService.login(request);
    }

    @PatchMapping("/token")
    public LoginResponse reissue(@RequestBody @Valid RefreshTokenRequest request) {
        return reissueService.reissue(String.valueOf(request));
    }
}
