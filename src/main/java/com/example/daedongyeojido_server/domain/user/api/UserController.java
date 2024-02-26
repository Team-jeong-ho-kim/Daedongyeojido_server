package com.example.daedongyeojido_server.domain.user.api;

import com.example.daedongyeojido_server.domain.user.application.FindAllUserService;
import com.example.daedongyeojido_server.domain.user.application.MyInfoService;
import com.example.daedongyeojido_server.domain.user.dto.request.PickSecretRequest;
import com.example.daedongyeojido_server.domain.user.dto.response.AllUserResponse;
import com.example.daedongyeojido_server.domain.user.dto.response.MyInfoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final MyInfoService myInfoService;

    private final FindAllUserService findAllUserService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/my-info")
    public MyInfoResponse myInfo() {
        return myInfoService.myInfo();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    public List<AllUserResponse> findAllUser(@RequestBody @Valid PickSecretRequest request) {
        return findAllUserService.findAllUser(request);
    }
}
