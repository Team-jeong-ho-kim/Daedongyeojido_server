package com.example.daedongyeojido_server.domain.user.dto.request;

import com.example.daedongyeojido_server.domain.user.domain.type.Part;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateUserRequest {

    private String name;

    private String classNumber;

    private Part part;

    private String clubName;
}
