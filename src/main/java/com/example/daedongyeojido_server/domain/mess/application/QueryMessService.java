package com.example.daedongyeojido_server.domain.mess.application;

import com.example.daedongyeojido_server.domain.mess.dao.MessRepository;
import com.example.daedongyeojido_server.domain.mess.domain.Mess;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryMessService {

    private final MessRepository messRepository;

    public List<Mess> queryMess() {
        return messRepository.findAll();
    }
}