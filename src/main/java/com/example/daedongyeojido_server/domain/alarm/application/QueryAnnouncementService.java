package com.example.daedongyeojido_server.domain.alarm.application;

import com.example.daedongyeojido_server.domain.alarm.dao.AlarmRepository;
import com.example.daedongyeojido_server.domain.alarm.domain.enums.AlarmType;
import com.example.daedongyeojido_server.domain.alarm.dto.response.AnnouncementResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryAnnouncementService {

    private final AlarmRepository alarmRepository;

    public List<AnnouncementResponse> queryAnnouncement() {
        return alarmRepository.findAllByAlarmType(AlarmType.ANNOUNCEMENT)
                .stream()
                .map(AnnouncementResponse::new)
                .collect(Collectors.toList());
    }
}
