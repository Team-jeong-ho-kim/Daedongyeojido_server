package com.example.daedongyeojido_server.domain.alarm.application;

import com.example.daedongyeojido_server.domain.alarm.dao.AlarmRepository;
import com.example.daedongyeojido_server.domain.alarm.dto.request.CancelResultRequest;
import com.example.daedongyeojido_server.domain.alarm.exception.WrongAlarmTypeException;
import com.example.daedongyeojido_server.domain.club.dao.ClubRepository;
import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.club.exception.ClubMisMatchException;
import com.example.daedongyeojido_server.domain.report.dao.ReportRepository;
import com.example.daedongyeojido_server.domain.report.domain.Report;
import com.example.daedongyeojido_server.domain.report.domain.enums.PassingResult;
import com.example.daedongyeojido_server.domain.user.application.facade.UserFacade;
import com.example.daedongyeojido_server.domain.user.dao.UserRepository;
import com.example.daedongyeojido_server.domain.user.domain.User;
import com.example.daedongyeojido_server.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CancelResultService {

    private final AlarmRepository alarmRepository;

    private final UserRepository userRepository;

    private final UserFacade userFacade;

    private final ReportRepository reportRepository;

    private final ClubRepository clubRepository;

    @Transactional
    public void cancelResult(CancelResultRequest request) {
        User user = userRepository.findByClassNumber(request.getClassNumber())
                        .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        Club club = clubRepository.findByClubName(request.getClubName());

        Report report = reportRepository.findByClassNumberAndNotice(user.getClassNumber(), club.getNotice());

        if (!(userFacade.currentUser().getMyClub().getClubName().equals(request.getClubName())))
            throw ClubMisMatchException.EXCEPTION;

        switch (request.getAlarmType()) {
            case INTERVIEW_PASS_RESULT -> {
                report.interviewResult(PassingResult.WAIT);
            }
            case REPORT_PASS_RESULT -> {
                report.reportResult(PassingResult.WAIT);
            }
            default -> throw WrongAlarmTypeException.EXCEPTION;
        }

        alarmRepository.deleteByClubNameAndUserAndAlarmType(request.getClubName(), user, request.getAlarmType());
    }
}
