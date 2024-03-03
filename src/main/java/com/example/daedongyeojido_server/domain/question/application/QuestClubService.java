package com.example.daedongyeojido_server.domain.question.application;

import com.example.daedongyeojido_server.domain.question.dao.QuestionRepository;
import com.example.daedongyeojido_server.domain.question.domain.Question;
import com.example.daedongyeojido_server.domain.question.dto.request.QuestRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QuestClubService {

    private final QuestionRepository questionRepository;

    @Transactional
    public void questClub(QuestRequest request) {
        questionRepository.save(
                Question.builder()
                        .question(request.getQuestion())
                        .build());
    }
}
