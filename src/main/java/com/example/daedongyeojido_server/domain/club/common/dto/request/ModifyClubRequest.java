package com.example.daedongyeojido_server.domain.club.common.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ModifyClubRequest {

    @NotBlank
    @Size(min = 1, max = 20, message = "동아리 이름은 1글자 이상, 20글자 이하여야 합니다.")
    private String clubName;

    @Size(max = 30, message = "동아리 타이틀은 30글자 이하로 작성하여야 합니다.")
    private String title;

    @Size(max = 500, message = "소개 글은 500글자 이하로 작성하여야 합니다.")
    private String introduction;

    private String clubImageUrl;

    private String clubBannerUrl;

    @Size(max = 6)
    private List<String> tags;
}