package com.example.daedongyeojido_server.domain.alarm.application;

import com.example.daedongyeojido_server.domain.alarm.dao.AlarmRepository;
import com.example.daedongyeojido_server.domain.alarm.domain.Alarm;
import com.example.daedongyeojido_server.domain.alarm.domain.enums.AlarmType;
import com.example.daedongyeojido_server.domain.alarm.dto.request.InterviewResultRequest;
import com.example.daedongyeojido_server.domain.report.dao.ReportRepository;
import com.example.daedongyeojido_server.domain.report.domain.Report;
import com.example.daedongyeojido_server.domain.report.exception.ReportNotFoundException;
import com.example.daedongyeojido_server.domain.user.dao.UserRepository;
import com.example.daedongyeojido_server.domain.user.domain.User;
import com.example.daedongyeojido_server.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InterviewResultService {

    private final AlarmRepository alarmRepository;

    private final ReportRepository reportRepository;

    private final UserRepository userRepository;

    public void interviewResult(InterviewResultRequest request) {
        Report report = reportRepository.findById(request.getReportId())
                .orElseThrow(()-> ReportNotFoundException.EXCEPTION);

        Alarm alarm = alarmRepository.save(
                Alarm.builder()
                        .clubName(report.getNotice().getClubName().getClubName())
                        .userName(report.getName())
                        .passingResult(request.getPassingResult())
                        .major(report.getNotice().getMajor())
                        .alarmType(AlarmType.PASS_RESULT)
                        .build());

        User user = userRepository.findByClassNumber(report.getClassNumber())
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        user.addAlarm(alarm);
    }
}
