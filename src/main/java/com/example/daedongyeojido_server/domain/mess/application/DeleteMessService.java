package com.example.daedongyeojido_server.domain.mess.application;

import com.example.daedongyeojido_server.domain.mess.dao.MessRepository;
import com.example.daedongyeojido_server.domain.mess.domain.Mess;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteMessService {
    private final MessRepository messRepository;

    @Transactional
    public void deleteMess(Long messId) {
        Mess mess = messRepository.findById(messId)
                .orElseThrow(RuntimeException::new);
        messRepository.delete(mess);
    }
}