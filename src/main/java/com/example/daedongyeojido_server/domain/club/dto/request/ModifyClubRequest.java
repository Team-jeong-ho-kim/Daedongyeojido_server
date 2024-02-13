package com.example.daedongyeojido_server.domain.club.dto.request;

import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ModifyClubRequest {

    @Size(max = 30, message = "동아리 타이틀은 30글자 이하로 작성하여야 합니다.")
    private String title;

    @Size(max = 500, message = "소개 글은 500글자 이하로 작성하여야 합니다.")
    private String introduction;

    @Size(max = 500, message = "프로젝트 소개는 300글자 이하로 작성하여야 합니다.")
    private String project;

    @Size(max = 500, message = "인재상은 300글자 이하로 작성하여야 합니다.")
    private String weWant;

    @Size(max = 500, message = "Q&A는 300글자 이하로 작성하여야 합니다.")
    private String qAndA;

    private String clubImageUrl;

    private List<String> tags;
}