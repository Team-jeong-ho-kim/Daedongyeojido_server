package com.example.daedongyeojido_server.domain.mess.application;

import com.example.daedongyeojido_server.domain.mess.dao.MessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteMessService {

    private final MessRepository messRepository;

    @Transactional
    public void deleteMess(Long messId) {
        messRepository.deleteById(messId);
    }
}