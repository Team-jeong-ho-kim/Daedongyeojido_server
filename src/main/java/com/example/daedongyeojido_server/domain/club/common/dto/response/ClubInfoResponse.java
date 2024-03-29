package com.example.daedongyeojido_server.domain.club.common.dto.response;

import com.example.daedongyeojido_server.domain.question.dto.response.QuestResponse;
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

    private String clubImageUrl;

    private String clubBannerUrl;

    private List<String> tags;

    private String teacherName;

    private List<ClubMemberResponse> clubMembers;

    private List<QuestResponse> questResponses;
}