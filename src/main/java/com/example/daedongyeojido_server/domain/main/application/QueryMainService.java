package com.example.daedongyeojido_server.domain.main.application;

import com.example.daedongyeojido_server.domain.alarm.dao.AlarmRepository;
import com.example.daedongyeojido_server.domain.alarm.domain.enums.AlarmType;
import com.example.daedongyeojido_server.domain.alarm.dto.response.AnnouncementResponse;
import com.example.daedongyeojido_server.domain.club.dao.ClubRepository;
import com.example.daedongyeojido_server.domain.club.dto.response.AllClubResponse;
import com.example.daedongyeojido_server.domain.main.dto.response.MainResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryMainService {

    private final ClubRepository clubRepository;

    private final AlarmRepository alarmRepository;

    @Transactional(readOnly = true)
    public MainResponse queryMain() {

        List<AllClubResponse> queryAllClubResponses = clubRepository.findAll()
                .stream()
                .map(AllClubResponse::new)
                .collect(Collectors.toList());

        List<AnnouncementResponse> announcementResponses = alarmRepository.findAllByAlarmType(AlarmType.ANNOUNCEMENT)
                .stream()
                .map(AnnouncementResponse::new)
                .collect(Collectors.toList());

        return new MainResponse(queryAllClubResponses, announcementResponses);
    }
}