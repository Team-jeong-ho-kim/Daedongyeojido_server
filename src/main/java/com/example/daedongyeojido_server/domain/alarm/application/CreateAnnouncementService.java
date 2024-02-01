package com.example.daedongyeojido_server.domain.alarm.application;

import com.example.daedongyeojido_server.domain.alarm.dao.AlarmRepository;
import com.example.daedongyeojido_server.domain.alarm.domain.Alarm;
import com.example.daedongyeojido_server.domain.alarm.domain.enums.AlarmType;
import com.example.daedongyeojido_server.domain.alarm.dto.request.CreateAnnouncementRequest;
import com.example.daedongyeojido_server.domain.user.application.UserFacade;
import com.example.daedongyeojido_server.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateAnnouncementService {

    private final AlarmRepository alarmRepository;

    private final UserFacade userFacade;

    @Transactional
    public void createAnnouncement(CreateAnnouncementRequest request) {
        User user = userFacade.currentTeacher();

        alarmRepository.save(
                Alarm.builder()
                        .title(request.getTitle())
                        .contents(request.getContents())
                        .alarmType(AlarmType.ANNOUNCEMENT)
                        .user(user)
                        .build());
    }
}