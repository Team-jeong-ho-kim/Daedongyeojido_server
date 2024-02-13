package com.example.daedongyeojido_server.domain.main.application;

import com.example.daedongyeojido_server.domain.main.dao.BannerRepository;
import com.example.daedongyeojido_server.domain.main.domain.Banner;
import com.example.daedongyeojido_server.domain.main.dto.request.BannerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AddBannerService {

    private final BannerRepository bannerRepository;

    @Transactional
    public void addBanner(BannerRequest request) {
        bannerRepository.save(
                Banner.builder()
                        .bannerImgUrl(request.getBannerImgUrl())
                        .build());
    }
}