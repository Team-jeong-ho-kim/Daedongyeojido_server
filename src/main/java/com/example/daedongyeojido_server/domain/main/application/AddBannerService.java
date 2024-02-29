package com.example.daedongyeojido_server.domain.main.application;

import com.example.daedongyeojido_server.domain.main.dao.BannerRepository;
import com.example.daedongyeojido_server.domain.main.domain.Banner;
import com.example.daedongyeojido_server.domain.main.dto.request.BannerRequest;
import com.example.daedongyeojido_server.domain.user.exception.InvalidKeyException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AddBannerService {

    private final BannerRepository bannerRepository;

    @Value("${key.daedong-secret-key}")
    private String secretKey;

    @Transactional
    public void addBanner(BannerRequest request) {

        if (!secretKey.equals(request.getSecretKey())) throw InvalidKeyException.EXCEPTION;

        bannerRepository.save(
                Banner.builder()
                        .bannerTitle(request.getBannerTitle())
                        .bannerImgUrl(request.getBannerImgUrl())
                        .build());
    }
}