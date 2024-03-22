package com.example.daedongyeojido_server.domain.notice.application;

import com.example.daedongyeojido_server.domain.notice.dto.request.MajorRequest;
import com.example.daedongyeojido_server.domain.user.application.facade.UserFacade;
import com.example.daedongyeojido_server.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SelectMajorService {

    private final UserFacade userFacade;

    @Transactional
    public void selectMajor(MajorRequest request) {
        User user = userFacade.currentUser();

        user.changeMajor(request.getMajor());
    }
}
