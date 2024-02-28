package com.example.daedongyeojido_server.domain.main.application;

import com.example.daedongyeojido_server.domain.club.dao.ClubRepository;
import com.example.daedongyeojido_server.domain.club.common.dto.response.AllClubResponse;
import com.example.daedongyeojido_server.domain.main.dao.BannerRepository;
import com.example.daedongyeojido_server.domain.main.domain.Banner;
import com.example.daedongyeojido_server.domain.main.dto.response.MainResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryMainService {

    private final BannerRepository bannerRepository;

    private final ClubRepository clubRepository;

    @Transactional(readOnly = true)
    public MainResponse queryMain() {

        List<Banner> banners = bannerRepository.findAll();

        List<AllClubResponse> queryAllClubResponses = clubRepository.findAll()
                .stream()
                .map(AllClubResponse::new)
                .collect(Collectors.toList());

        return new MainResponse(banners, queryAllClubResponses);
    }
}