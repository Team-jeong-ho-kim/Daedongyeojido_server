package com.example.daedongyeojido_server.domain.alarm.application;

import com.example.daedongyeojido_server.domain.alarm.dao.AlarmRepository;
import com.example.daedongyeojido_server.domain.mess.dao.MessRepository;
import com.example.daedongyeojido_server.domain.mess.domain.Mess;
import com.example.daedongyeojido_server.domain.mess.exception.MessNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CancelMessService {

    private final MessRepository messRepository;

    private final AlarmRepository alarmRepository;

    @Transactional
    public void cancelAlarm(Long messId) {
        Mess mess = messRepository.findById(messId)
                .orElseThrow(()-> MessNotFoundException.EXCEPTION);

        mess.acceptOrCancelMess(-1);
//        if (mess.getMessAccept() <= 1) {
//            alarmRepository.deleteById();
//        }
    }
}
