package com.example.daedongyeojido_server.domain.club.dto.response;

import com.example.daedongyeojido_server.domain.alarm.dto.response.AnnouncementResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class MainResponse {

    private List<AllClubResponse> allClubResponses;

    private List<AnnouncementResponse> announcement;
}
