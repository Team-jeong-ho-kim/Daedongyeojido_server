package com.example.daedongyeojido_server.infra.feign;

import com.example.daedongyeojido_server.infra.feign.dto.request.XquareUserRequest;
import com.example.daedongyeojido_server.infra.feign.dto.response.XquareUserResponse;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "xquare-client", url = "${key.xquare-api-url}")
public interface XquareClient {

    @GetMapping("/user-data")
    XquareUserResponse xquareUser(@RequestBody @Valid XquareUserRequest request);
}