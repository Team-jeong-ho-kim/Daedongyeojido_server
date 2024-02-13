package com.example.daedongyeojido_server.domain.main.api;

import com.example.daedongyeojido_server.domain.main.application.AddBannerService;
import com.example.daedongyeojido_server.domain.main.dto.request.BannerRequest;
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
@RequestMapping("/jung-ho/main")
public class MainController {

    private final AddBannerService addBannerService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/banner")
    public void addBanner(@RequestBody @Valid BannerRequest request) {
        addBannerService.addBanner(request);
    }
}
