package com.example.daedongyeojido_server.infra.feign;

import com.example.daedongyeojido_server.infra.feign.dto.response.XquareUserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "xquare-client", url = "https://prod-server.xquare.app/users/account-id")
public interface XquareClient {

    @GetMapping("/{accountId}")
    XquareUserResponse xquareUser(@PathVariable String accountId);
}
