package com.example.daedongyeojido_server.domain.question.application;

import com.example.daedongyeojido_server.domain.club.dao.ClubRepository;
import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.question.dao.QuestionRepository;
import com.example.daedongyeojido_server.domain.question.dto.response.QuestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryQuestionService {

    private final ClubRepository clubRepository;

    private final QuestionRepository questionRepository;

    @Transactional(readOnly = true)
    public List<QuestResponse> queryQuestion(String clubName) {
        Club club = clubRepository.findByClubName(clubName);

        return questionRepository.findAllByClub(club)
                .stream()
                .map(QuestResponse::new)
                .collect(Collectors.toList());
    }
}
