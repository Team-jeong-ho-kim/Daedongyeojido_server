package com.example.daedongyeojido_server.domain.club.common.dto.response;

import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.notice.dto.response.MajorResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class AllClubResponse {

    private String clubName;

    private String title;

    private String clubImageUrl;

    private List<MajorResponse> majors;

    private List<String> tags;

    public AllClubResponse(Club club) {
        clubName = club.getClubName();
        title = club.getTitle();
        clubImageUrl = club.getClubImageUrl();
        if(club.getNotice() == null) majors = null;
        else majors = club.getNotice().getFields().stream().map(MajorResponse::new).toList();
        tags = club.getTags().subList(0, Math.min(3, club.getTags().size()));
    }
}