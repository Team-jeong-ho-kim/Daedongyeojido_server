package com.example.daedongyeojido_server.domain.club.common.dto.response;

import com.example.daedongyeojido_server.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClubMemberResponse {

    private String name;

    public ClubMemberResponse(User user) {
        name = user.getName();
    }
}