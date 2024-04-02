package com.example.daedongyeojido_server.domain.interview.application;

import com.example.daedongyeojido_server.domain.club.exception.ClubMisMatchException;
import com.example.daedongyeojido_server.domain.interview.dao.InterviewTimeRepository;
import com.example.daedongyeojido_server.domain.interview.dto.request.DeleteInterviewTimeRequest;
import com.example.daedongyeojido_server.domain.user.application.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteInterviewTimeService {

    private final InterviewTimeRepository interviewTimeRepository;

    private final UserFacade userFacade;

    @Transactional
    public void deleteInterviewTime(DeleteInterviewTimeRequest request) {
        if (!(userFacade.currentUser().getMyClub().getClubName().equals(request.getClubName())))
            throw ClubMisMatchException.EXCEPTION;

        interviewTimeRepository.deleteById(request.getInterviewTimeId());
    }
}
