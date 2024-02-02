package com.example.daedongyeojido_server.domain.mess.application;

import com.example.daedongyeojido_server.domain.mess.dao.MessRepository;
import com.example.daedongyeojido_server.domain.mess.dto.response.QueryMessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryMessService {

    private final MessRepository messRepository;

    @Transactional
    public List<QueryMessResponse> queryMess() {

        return messRepository.findAll()
                .stream()
                .map(QueryMessResponse::new)
                .collect(Collectors.toList());
    }
}