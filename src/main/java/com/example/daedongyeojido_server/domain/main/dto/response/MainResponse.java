package com.example.daedongyeojido_server.domain.main.dto.response;

import com.example.daedongyeojido_server.domain.alarm.dto.response.AnnouncementResponse;
import com.example.daedongyeojido_server.domain.club.common.dto.response.AllClubResponse;
import com.example.daedongyeojido_server.domain.main.domain.Banner;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class MainResponse {

    private List<Banner> banners;

    private List<AllClubResponse> allClubResponses;
}
