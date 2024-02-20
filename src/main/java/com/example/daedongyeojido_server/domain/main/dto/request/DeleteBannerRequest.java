package com.example.daedongyeojido_server.domain.main.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeleteBannerRequest {

    private String secretKey;

    private Long bannerId;
}
