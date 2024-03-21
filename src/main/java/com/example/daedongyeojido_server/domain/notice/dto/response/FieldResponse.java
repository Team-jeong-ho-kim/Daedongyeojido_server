package com.example.daedongyeojido_server.domain.notice.dto.response;

import com.example.daedongyeojido_server.domain.notice.domain.Field;
import com.example.daedongyeojido_server.domain.notice.domain.enums.Major;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FieldResponse {

    private Major major;

    private String todo;

    public FieldResponse(Field field) {
        major = field.getMajor();
        todo = field.getToDo();
    }
}
