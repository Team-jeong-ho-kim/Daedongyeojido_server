package com.example.daedongyeojido_server.infra.feign;

import com.example.daedongyeojido_server.infra.feign.dto.response.XquareUserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "xquare-client", url = "${key.xquare-api-url}")
public interface XquareClient {

    @GetMapping("/{accountId}")
    XquareUserResponse xquareUser(@PathVariable String accountId);
}
