package com.example.daedongyeojido_server.domain.interview.application;

import com.example.daedongyeojido_server.domain.club.exception.ClubMisMatchException;
import com.example.daedongyeojido_server.domain.interview.dao.InterviewTimeRepository;
import com.example.daedongyeojido_server.domain.interview.dto.response.InterviewTimeResponse;
import com.example.daedongyeojido_server.domain.user.application.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryClubInterviewTimeService {

    private final InterviewTimeRepository interviewTimeRepository;

    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public List<InterviewTimeResponse> queryClubInterviewTime(String clubName) {
        if (!(userFacade.currentUser().getMyClub().getClubName().equals(clubName)))
            throw ClubMisMatchException.EXCEPTION;

        return interviewTimeRepository.findAllByClubName(clubName)
                .stream()
                .map(InterviewTimeResponse::new)
                .collect(Collectors.toList());
    }
}
