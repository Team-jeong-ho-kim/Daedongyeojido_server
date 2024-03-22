package com.example.daedongyeojido_server.domain.club.common.dto.response;

import com.example.daedongyeojido_server.domain.notice.domain.enums.Major;
import com.example.daedongyeojido_server.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClubMemberResponse {

    private String name;

    private Major major;

    private String oneLiner;

    private String profileImageUrl;

    public ClubMemberResponse(User user) {
        name = user.getName();
        major = user.getMajor();
        oneLiner = user.getUserId();
        profileImageUrl = user.getProfileImageUrl();
    }
}