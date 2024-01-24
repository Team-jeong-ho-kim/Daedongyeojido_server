package com.example.daedongyeojido_server.domain.user.application;

import com.example.daedongyeojido_server.domain.user.domain.User;
import com.example.daedongyeojido_server.domain.user.dto.response.MyInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyInfoService {

    private final UserFacade userFacade;

    public MyInfoResponse myInfo() {
        User user = userFacade.currentTeacher();

        return MyInfoResponse.builder()
                .classNumber(user.getClassNumber())
                .name(user.getName())
                .part(user.getPart())
                .myClub(user.getMyClub())
                .build();
    }
}
