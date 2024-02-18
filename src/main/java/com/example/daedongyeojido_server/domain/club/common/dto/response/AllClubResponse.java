package com.example.daedongyeojido_server.domain.club.common.dto.response;

import com.example.daedongyeojido_server.domain.club.common.domain.Club;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public class AllClubResponse {

    private String clubName;

    private String title;

    private String clubImageUrl;

    private List<String> tags;

    public AllClubResponse(Club club) {
        clubName = club.getClubName();
        title = club.getTitle();
        clubImageUrl = club.getClubImageUrl();
        tags = club.getTags().subList(0, Math.min(3, club.getTags().size()));
    }
}