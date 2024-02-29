package com.example.daedongyeojido_server.domain.main.api;

import com.example.daedongyeojido_server.domain.main.application.AddBannerService;
import com.example.daedongyeojido_server.domain.main.application.DeleteBannerService;
import com.example.daedongyeojido_server.domain.main.application.QueryMainService;
import com.example.daedongyeojido_server.domain.main.dto.request.BannerRequest;
import com.example.daedongyeojido_server.domain.main.dto.request.DeleteBannerRequest;
import com.example.daedongyeojido_server.domain.main.dto.response.MainResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainController {

    private final AddBannerService addBannerService;

    private final DeleteBannerService deleteBannerService;

    private final QueryMainService queryMainService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/banner")
    public void addBanner(@RequestBody @Valid BannerRequest request) {
        addBannerService.addBanner(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/banner")
    public void deleteBanner(@RequestBody @Valid DeleteBannerRequest request) {
        deleteBannerService.deleteBanner(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public MainResponse queryMain() {
        return queryMainService.queryMain();
    }
}