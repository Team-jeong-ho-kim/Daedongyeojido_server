package com.example.daedongyeojido_server.domain.club.dto.request;

import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import com.example.daedongyeojido_server.domain.user.domain.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdateClubRequest {

    @NotBlank
    @Size(min = 1, max = 20, message = "clubname은 1글자 이상, 20글자 이하여야 합니다.")
    private String clubName;

    @Size(max = 30, message = "제목은 30글자 이하로 작성하여야 합니다.")
    private String title;

    @Size(max = 300, message = "소개 글은 300글자 이하로 작성하여야 합니다.")
    private String content;

    private String clubImageUrl;

    private List<User> clubMembers;

    private List<String> tags;

    private List<Notice> notices;
}