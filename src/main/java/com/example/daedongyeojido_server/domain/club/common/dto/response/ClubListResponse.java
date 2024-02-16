package com.example.daedongyeojido_server.domain.club.common.dto.response;

import com.example.daedongyeojido_server.domain.club.common.domain.Club;
import com.example.daedongyeojido_server.domain.user.dto.response.MemberResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class ClubListResponse {

    private String clubName;

    private String teacherName;

    private int messCount = 0;

    private List<MemberResponse> memberResponses;

    public ClubListResponse(Club club) {
        if(club.getTeacher() == null) teacherName = "null";
        else teacherName = club.getTeacher().getName();

        clubName = club.getClubName();
        messCount = club.getMessCount();
        memberResponses = club.getClubMembers()
                .stream()
                .map(MemberResponse::new)
                .collect(Collectors.toList());
    }
}
