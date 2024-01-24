package com.example.daedongyeojido_server.domain.user.application;

import com.example.daedongyeojido_server.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyInfoService {

    private final UserFacade userFacade;

    public User myInfo() {
        return userFacade.currentTeacher();
    }
}
