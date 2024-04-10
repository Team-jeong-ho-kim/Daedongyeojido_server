package com.example.daedongyeojido_server.domain.question.application;

import com.example.daedongyeojido_server.domain.question.dao.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteClubQuestService {

    private final QuestionRepository questionRepository;

    @Transactional
    public void deleteClubQuest(Long clubQuestId) {
        questionRepository.deleteById(clubQuestId);
    }
}
