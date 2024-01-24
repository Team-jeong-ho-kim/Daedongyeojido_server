package com.example.daedongyeojido_server.domain.club.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClubInfoRequest {

    private String clubName;
}