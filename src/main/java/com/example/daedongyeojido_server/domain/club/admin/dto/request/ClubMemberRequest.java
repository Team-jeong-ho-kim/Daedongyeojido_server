package com.example.daedongyeojido_server.domain.club.admin.dto.request;

import com.example.daedongyeojido_server.domain.user.domain.enums.Part;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClubMemberRequest {

    @Size(min = 3, max = 4, message = "이름은 3글자 이상, 4글자 이하여야 합니다.")
    private String name;

    @Size(min = 4, max = 4, message = "학번은 4글자 이어야 합니다.")
    private String classNumber;

    @NotNull
    private Part part;
}