package com.example.daedongyeojido_server.domain.auth.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudentLoginRequest {

    @NotBlank
    @Size(min = 4, max = 4, message = "classNumber는 4글자 이여야 합니다.")
    private String classNumber;
}
