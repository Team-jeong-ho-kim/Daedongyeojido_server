package com.example.daedongyeojido_server.domain.club.common.application;

import com.example.daedongyeojido_server.domain.club.common.dao.InterviewTimeRepository;
import com.example.daedongyeojido_server.domain.club.common.domain.InterviewTime;
import com.example.daedongyeojido_server.domain.club.common.dto.request.InterviewTimeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModifyInterviewTimeService {

    private final InterviewTimeRepository interviewTimeRepository;

    @Transactional
    public void modifyInterviewTime(String clubName, List<InterviewTimeRequest> requests) {
        interviewTimeRepository.deleteAllByClubName(clubName);

        for(int i=0; i<requests.size(); i++) {
            interviewTimeRepository.save(
                    InterviewTime.builder()
                            .interviewStartTime(requests.get(i).getInterviewStartTime())
                            .interviewEndTime(requests.get(i).getInterviewEndTime())
                            .build());
        }
    }
}
