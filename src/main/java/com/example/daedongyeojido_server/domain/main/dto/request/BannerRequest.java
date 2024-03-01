package com.example.daedongyeojido_server.domain.main.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BannerRequest {

    @NotBlank
    private String secretKey;

    @NotBlank
    private String bannerTitle;

    @NotBlank
    private String bannerImgUrl;
}