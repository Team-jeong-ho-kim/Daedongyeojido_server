package com.example.daedongyeojido_server.domain.user.dto.response;

import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.user.domain.enums.Part;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MyInfoResponse {

    private String classNumber;

    private String name;

    private Part part;

    private Club myClub;
}