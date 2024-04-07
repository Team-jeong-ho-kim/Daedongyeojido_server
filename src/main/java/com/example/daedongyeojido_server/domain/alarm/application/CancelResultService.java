package com.example.daedongyeojido_server.domain.alarm.application;

import com.example.daedongyeojido_server.domain.alarm.dao.AlarmRepository;
import com.example.daedongyeojido_server.domain.alarm.dto.request.CancelResultRequest;
import com.example.daedongyeojido_server.domain.club.exception.ClubMisMatchException;
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

    @Transactional
    public void cancelResult(CancelResultRequest request) {
        User user = userRepository.findByClassNumber(request.getClassNumber())
                        .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        if (!(userFacade.currentUser().getMyClub().getClubName().equals(request.getClubName())))
            throw ClubMisMatchException.EXCEPTION;

        alarmRepository.deleteByClubNameAndUserAndAlarmType(request.getClubName(), user, request.getAlarmType());
    }
}
