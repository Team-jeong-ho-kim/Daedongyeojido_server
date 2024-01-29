package com.example.daedongyeojido_server.domain.club.dto.response;

import com.example.daedongyeojido_server.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ClubInfoResponse {

    private String clubName;

    private String title;

    private String contents;

    private String clubImageUrl;

    private List<String> tags;

    private List<User> clubMembers;
}