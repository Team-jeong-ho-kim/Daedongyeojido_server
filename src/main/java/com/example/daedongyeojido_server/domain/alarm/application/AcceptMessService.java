package com.example.daedongyeojido_server.domain.alarm.application;

import com.example.daedongyeojido_server.domain.alarm.dao.AlarmRepository;
import com.example.daedongyeojido_server.domain.alarm.domain.Alarm;
import com.example.daedongyeojido_server.domain.alarm.exception.NotValidTeacherException;
import com.example.daedongyeojido_server.domain.mess.dao.MessRepository;
import com.example.daedongyeojido_server.domain.mess.domain.Mess;
import com.example.daedongyeojido_server.domain.mess.exception.MessNotFoundException;
import com.example.daedongyeojido_server.domain.user.application.UserFacade;
import com.example.daedongyeojido_server.domain.user.dao.CustomUserRepository;
import com.example.daedongyeojido_server.domain.user.domain.User;
import com.example.daedongyeojido_server.domain.user.domain.enums.Part;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AcceptMessService {

    private final UserFacade userFacade;

    private final MessRepository messRepository;

    private final AlarmRepository alarmRepository;

    private final CustomUserRepository customUserRepository;

    @Transactional
    public void acceptMess(Long messId) {
        User teacher = userFacade.currentTeacher();

        Mess mess = messRepository.findById(messId)
                .orElseThrow(()-> MessNotFoundException.EXCEPTION);

        if(teacher.getPart()!= Part.CLUB_LEADER_TEACHER || teacher!=mess.getMyclub().getTeacher()) {
            throw NotValidTeacherException.EXCEPTION;
        }

        mess.acceptOrCancelMess(1);

        if(mess.getMessAccept() >= 2) {
            Alarm alarm = alarmRepository.save(
                    Alarm.builder()
                            .clubName(mess.getMyclub().getClubName())
                            .build());

            User leader = customUserRepository.findLeaderByClub(mess.getMyclub());
            leader.addAlarm(alarm);
        }
    }
}