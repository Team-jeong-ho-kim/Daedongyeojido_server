package com.example.daedongyeojido_server.domain.club.admin.dto.response;

import com.example.daedongyeojido_server.domain.club.domain.Club;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class AdminPageResponse {

    private String clubName;

    private String teacherName;

    private int messCount = 0;

    private List<MemberResponse> memberResponses;

    public AdminPageResponse(Club club) {
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
