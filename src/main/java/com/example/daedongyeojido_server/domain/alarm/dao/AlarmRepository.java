package com.example.daedongyeojido_server.domain.alarm.dao;

import com.example.daedongyeojido_server.domain.alarm.domain.Alarm;
import com.example.daedongyeojido_server.domain.alarm.domain.enums.AlarmType;
import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlarmRepository extends JpaRepository<Alarm, Long> {
    List<Alarm> findAllByUser(User user);

    void deleteByClubNameAndUserAndAlarmType(String clubName, User user, AlarmType alarmType);
}