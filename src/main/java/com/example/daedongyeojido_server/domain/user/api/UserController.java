package com.example.daedongyeojido_server.domain.user.api;

import com.example.daedongyeojido_server.domain.user.application.CreateUserService;
import com.example.daedongyeojido_server.domain.user.dto.request.CreateUserRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final CreateUserService createUserService;

    @PostMapping()
    public void createUser(@RequestBody @Valid CreateUserRequest request) {
        createUserService.createUser(request);
    }
}
