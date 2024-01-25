package com.example.daedongyeojido_server.domain.mess.application;

import com.example.daedongyeojido_server.domain.mess.dao.MessRepository;
import com.example.daedongyeojido_server.domain.mess.domain.Mess;
import com.example.daedongyeojido_server.domain.mess.dto.request.CreateMessRequest;
import com.example.daedongyeojido_server.domain.mess.exception.ExistMessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateMessService {

    private final MessRepository messRepository;

    @Transactional
    public void createMess(CreateMessRequest request) {

        if (messRepository.existsById(request.getMessId())) throw ExistMessException.EXCEPTION;

        messRepository.save(Mess.builder()
                .messDate(request.getMessDate())
                .messStartTime(request.getMessStartTime())
                .messEndTime(request.getMessEndTime())
                .build());
    }
}