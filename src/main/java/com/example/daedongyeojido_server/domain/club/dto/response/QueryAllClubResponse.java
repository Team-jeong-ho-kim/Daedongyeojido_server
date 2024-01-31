package com.example.daedongyeojido_server.domain.club.dto.response;

import com.example.daedongyeojido_server.domain.club.domain.Club;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryAllClubResponse {

    private String clubName;

    private String title;

    private String clubImageUrl;

    private List<String> tags;

    public QueryAllClubResponse(Club club) {
        clubName = club.getClubName();
        title = club.getTitle();
        clubImageUrl = club.getClubImageUrl();
        tags = club.getTags();
    }
}