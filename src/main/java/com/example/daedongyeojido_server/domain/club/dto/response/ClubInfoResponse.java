package com.example.daedongyeojido_server.domain.club.dto.response;

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

    private String introduction;

    private String project;

    private String weWant;

    private String qAndA;

    private String clubImageUrl;

    private List<String> tags;

    private List<ClubMemberResponse> clubMembers;
}