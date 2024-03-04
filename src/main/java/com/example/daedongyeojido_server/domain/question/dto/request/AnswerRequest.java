package com.example.daedongyeojido_server.domain.question.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AnswerRequest {

    @NotNull
    private Long clubQuestId;

    @NotBlank
    @Size(max = 30, message = "답변은 30글자 이하여야 합니다.")
    private String answer;
}
