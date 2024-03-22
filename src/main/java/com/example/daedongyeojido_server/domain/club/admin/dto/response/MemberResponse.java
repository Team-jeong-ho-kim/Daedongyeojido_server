package com.example.daedongyeojido_server.domain.club.admin.dto.response;

import com.example.daedongyeojido_server.domain.notice.domain.enums.Major;
import com.example.daedongyeojido_server.domain.user.domain.User;
import com.example.daedongyeojido_server.domain.user.domain.enums.Part;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberResponse {

    private String userName;

    private String classNumber;

    private Part part;

    private Major major;

    public MemberResponse(User user) {
        userName = user.getName();
        classNumber = user.getClassNumber();
        part = user.getPart();
        major = user.getMajor();
    }
}