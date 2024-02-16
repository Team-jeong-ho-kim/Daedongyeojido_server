package com.example.daedongyeojido_server.domain.mess.application;

import com.example.daedongyeojido_server.domain.mess.dao.MessRepository;
import com.example.daedongyeojido_server.domain.mess.domain.Mess;
import com.example.daedongyeojido_server.domain.mess.dto.request.CreateMessRequest;
import com.example.daedongyeojido_server.domain.mess.exception.ExistMessException;
import com.example.daedongyeojido_server.domain.user.application.facade.UserFacade;
import com.example.daedongyeojido_server.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateMessService {

    private final MessRepository messRepository;

    private final UserFacade userFacade;

    @Transactional
    public void createMess(CreateMessRequest request) {

        User user = userFacade.currentUser();

        if (messRepository.findByMyClub(user.getMyClub()).isPresent()) {
            throw ExistMessException.EXCEPTION;
        }

        messRepository.save(
                Mess.builder()
                        .messDate(request.getMessDate())
                        .messStartTime(request.getMessStartTime())
                        .messEndTime(request.getMessEndTime())
                        .MessAccept(0)
                        .myClub(user.getMyClub())
                        .build());
    }
}