package com.example.daedongyeojido_server.domain.main.application;

import com.example.daedongyeojido_server.domain.main.dao.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteBannerService {

    private final BannerRepository bannerRepository;

    @Transactional
    public void deleteBanner(Long bannerId) {
        bannerRepository.deleteById(bannerId);
    }
}
