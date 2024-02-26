package com.example.daedongyeojido_server.domain.alarm.dto.response;

import com.example.daedongyeojido_server.domain.alarm.domain.Alarm;
import com.example.daedongyeojido_server.domain.alarm.domain.enums.AlarmType;
import com.example.daedongyeojido_server.domain.notice.domain.enums.Major;
import com.example.daedongyeojido_server.domain.report.domain.enums.PassingResult;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AlarmResponse {

    private Long alarmId;

    private String title;

    private String contents;

    private String clubName;

    private String userName;

    private LocalDateTime createTime;

    private PassingResult passingResult;

    private Major major;

    private AlarmType alarmType;

    public AlarmResponse(Alarm alarm) {
        alarmId = alarm.getAlarmId();
        title = alarm.getTitle();
        contents = alarm.getContents();
        clubName = alarm.getClubName();
        userName = alarm.getUserName();
        createTime = alarm.getCreateTime();
        passingResult = alarm.getPassingResult();
        major = alarm.getMajor();
        alarmType = alarm.getAlarmType();
    }
}