package com.example.daedongyeojido_server.domain.club.admin.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EditClubMemberRequest {

    @NotBlank
    @Size(min = 1, max = 20, message = "동아리 이름은 1글자 이상, 20글자 이하여야 합니다.")
    private String clubName;

    @Size(min = 3, max = 4, message = "이름은 3글자 이상, 4글자 이하여야 합니다.")
    private String teacherName;

    private List<ClubMemberRequest> clubMembers;
}