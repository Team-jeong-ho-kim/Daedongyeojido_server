package com.example.daedongyeojido_server.domain.alarm.application;

import com.example.daedongyeojido_server.domain.alarm.dao.AlarmRepository;
import com.example.daedongyeojido_server.domain.alarm.dto.response.AlarmResponse;
import com.example.daedongyeojido_server.domain.user.application.facade.UserFacade;
import com.example.daedongyeojido_server.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MyAlarmService {

    private final AlarmRepository alarmRepository;

    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public List<AlarmResponse> myAlarm() {
        User user = userFacade.currentUser();

        return alarmRepository.findAllByUser(user)
                .stream()
                .map(AlarmResponse::new)
                .collect(Collectors.toList());
    }
}