package com.example.daedongyeojido_server.domain.question.application;

import com.example.daedongyeojido_server.domain.club.dao.ClubRepository;
import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.question.dao.QuestionRepository;
import com.example.daedongyeojido_server.domain.question.domain.QandA;
import com.example.daedongyeojido_server.domain.question.dto.request.QuestRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QuestClubService {

    private final ClubRepository clubRepository;

    private final QuestionRepository questionRepository;

    @Transactional
    public void questClub(QuestRequest request) {
        Club club = clubRepository.findByClubName(request.getClubName());

        questionRepository.save(
                QandA.builder()
                        .question(request.getQuestion())
                        .club(club)
                        .build());
    }
}
