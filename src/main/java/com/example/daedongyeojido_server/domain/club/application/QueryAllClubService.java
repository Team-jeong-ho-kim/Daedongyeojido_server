package com.example.daedongyeojido_server.domain.club.application;

import com.example.daedongyeojido_server.domain.alarm.dao.AlarmRepository;
import com.example.daedongyeojido_server.domain.alarm.domain.Alarm;
import com.example.daedongyeojido_server.domain.alarm.domain.enums.AlarmType;
import com.example.daedongyeojido_server.domain.alarm.dto.response.AnnouncementResponse;
import com.example.daedongyeojido_server.domain.club.dao.ClubRepository;
import com.example.daedongyeojido_server.domain.club.dto.response.AllClubResponse;
import com.example.daedongyeojido_server.domain.club.dto.response.MainResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryAllClubService {

    private final ClubRepository clubRepository;

    private final AlarmRepository alarmRepository;

    @Transactional
    public MainResponse queryAllClub() {

        List<AllClubResponse> queryAllClubResponses = clubRepository.findAll()
                .stream()
                .map(AllClubResponse::new)
                .collect(Collectors.toList());

        Alarm announcement = alarmRepository.findByAlarmType(AlarmType.ANNOUNCEMENT);

        return new MainResponse(queryAllClubResponses, new AnnouncementResponse(announcement));
    }
}