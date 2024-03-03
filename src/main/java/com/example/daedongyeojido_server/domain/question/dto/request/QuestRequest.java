package com.example.daedongyeojido_server.domain.question.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuestRequest {

    @NotBlank
    @Size(max = 50, message = "질문은 20글자 이하여야 합니다.")
    private String question;
}
