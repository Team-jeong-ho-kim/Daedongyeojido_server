package com.example.daedongyeojido_server.domain.notice.dto.request;

import com.example.daedongyeojido_server.domain.notice.domain.enums.Major;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FieldRequest {

    @NotNull
    private Major major;

    @NotBlank
    private String toDo;
}
