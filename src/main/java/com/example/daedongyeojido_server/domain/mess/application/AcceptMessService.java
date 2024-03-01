package com.example.daedongyeojido_server.domain.mess.application;

import com.example.daedongyeojido_server.domain.alarm.dao.AlarmRepository;
import com.example.daedongyeojido_server.domain.alarm.domain.Alarm;
import com.example.daedongyeojido_server.domain.alarm.domain.enums.AlarmType;
import com.example.daedongyeojido_server.domain.alarm.exception.NotValidTeacherException;
import com.example.daedongyeojido_server.domain.mess.dao.MessRepository;
import com.example.daedongyeojido_server.domain.mess.domain.Mess;
import com.example.daedongyeojido_server.domain.mess.exception.MessNotFoundException;
import com.example.daedongyeojido_server.domain.user.application.facade.UserFacade;
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
        User teacher = userFacade.currentUser();

        Mess mess = messRepository.findById(messId)
                .orElseThrow(() -> MessNotFoundException.EXCEPTION);

        if (teacher.getPart() != Part.CLUB_LEADER_TEACHER && !(teacher.getName().equals(mess.getMyClub().getTeacher().getName()))) {
            System.out.println(mess.getMyClub().getTeacher());
            throw NotValidTeacherException.EXCEPTION;
        }

        if (mess.getAcceptTeachers().contains(teacher.getName())) {
            mess.acceptOrCancelMess(-1, teacher.getName());
        } else {
            mess.acceptOrCancelMess(1, teacher.getName());
        }

        if (mess.getMessAccept() >= 2) {
            User leader = customUserRepository.findLeaderByClub(mess.getMyClub());

            Alarm alarm = alarmRepository.save(
                    Alarm.builder()
                            .clubName(mess.getMyClub().getClubName())
                            .userName(leader.getName())
                            .alarmType(AlarmType.MESS_ACCEPT)
                            .user(leader)
                            .build());

            leader.addAlarm(alarm);

            messRepository.deleteById(messId);
        }
    }
}