package com.example.daedongyeojido_server.domain.main.dto.response;

import com.example.daedongyeojido_server.domain.alarm.dto.response.AnnouncementResponse;
import com.example.daedongyeojido_server.domain.club.dto.response.AllClubResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class MainResponse {

    private List<AllClubResponse> allClubResponses;

    private List<AnnouncementResponse> announcement;
}
