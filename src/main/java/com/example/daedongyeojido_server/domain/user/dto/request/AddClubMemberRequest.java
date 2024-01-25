package com.example.daedongyeojido_server.domain.user.dto.request;

import com.example.daedongyeojido_server.domain.user.domain.enums.Part;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddClubMemberRequest {

    @NotBlank
    @Size(min = 4, max = 4, message = "classNumber는 4글자 이여야 합니다.")
    private String classNumber;

    @NotBlank
    @Size(min = 3, max = 4, message = "name은 3글자 이상, 4글자 이하여야 합니다.")
    private String name;

    private Part part;

    @NotBlank
    @Size(min = 1, max = 20, message = "clubname은 1글자 이상, 20글자 이하여야 합니다.")
    private String clubName;
}
