package com.example.daedongyeojido_server.domain.club.dto.request;

import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ModifyClubRequest {

    @Size(min = 1, max = 30, message = "제목은 30글자 이하로 작성하여야 합니다.")
    private String title;

    @Size(min = 1, max = 300, message = "소개 글은 300글자 이하로 작성하여야 합니다.")
    private String content;

    private String clubImageUrl;

    private List<String> tags;
}