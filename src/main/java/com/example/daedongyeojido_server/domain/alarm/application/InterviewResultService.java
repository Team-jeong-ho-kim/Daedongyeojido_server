package com.example.daedongyeojido_server.domain.alarm.application;

import com.example.daedongyeojido_server.domain.alarm.dao.AlarmRepository;
import com.example.daedongyeojido_server.domain.alarm.domain.Alarm;
import com.example.daedongyeojido_server.domain.alarm.domain.enums.AlarmType;
import com.example.daedongyeojido_server.domain.alarm.dto.request.InterviewResultRequest;
import com.example.daedongyeojido_server.domain.alarm.exception.WrongAlarmTypeException;
import com.example.daedongyeojido_server.domain.report.application.facade.ReportFacade;
import com.example.daedongyeojido_server.domain.report.domain.Report;
import com.example.daedongyeojido_server.domain.user.dao.UserRepository;
import com.example.daedongyeojido_server.domain.user.domain.User;
import com.example.daedongyeojido_server.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class InterviewResultService {

    private final ReportFacade reportFacade;

    private final UserRepository userRepository;

    private final AlarmRepository alarmRepository;

    @Transactional
    public void interviewResult(InterviewResultRequest request) {
        Report report = reportFacade.reportFacade(request.getReportId());

        User user = userRepository.findByClassNumber(report.getClassNumber())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        AlarmType alarmType;

        switch (request.getAlarmType()) {
            case INTERVIEW_PASS_RESULT -> alarmType = AlarmType.INTERVIEW_PASS_RESULT;
            case REPORT_PASS_RESULT -> alarmType = AlarmType.REPORT_PASS_RESULT;
            default -> throw WrongAlarmTypeException.EXCEPTION;
        }

        Alarm alarm = alarmRepository.save(
                Alarm.builder()
                        .clubName(report.getNotice().getClubName().getClubName())
                        .userName(report.getName())
                        .createTime(LocalDateTime.now())
                        .passingResult(request.getPassingResult())
                        .major(report.getNotice().getMajor())
                        .alarmType(alarmType)
                        .user(user)
                        .build());

        report.reportResult(request.getPassingResult());

        user.addAlarm(alarm);
    }
}