package com.example.daedongyeojido_server.domain.question.application;

import com.example.daedongyeojido_server.domain.club.exception.ClubMisMatchException;
import com.example.daedongyeojido_server.domain.question.dao.QuestionRepository;
import com.example.daedongyeojido_server.domain.question.domain.ClubQuest;
import com.example.daedongyeojido_server.domain.question.dto.request.AnswerRequest;
import com.example.daedongyeojido_server.domain.question.exception.ClubQuestNotFoundException;
import com.example.daedongyeojido_server.domain.user.application.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AnswerQuestionService {

    private final QuestionRepository questionRepository;

    private final UserFacade userFacade;

    @Transactional
    public void answerQuest(AnswerRequest request) {
        ClubQuest clubQuest = questionRepository.findById(request.getClubQuestId())
                .orElseThrow(()-> ClubQuestNotFoundException.EXCEPTION);

        if(!(userFacade.currentUser().getMyClub().equals(clubQuest.getClub()))) throw ClubMisMatchException.EXCEPTION;

        clubQuest.answerQuestion(request.getAnswer());
        clubQuest.getClub().addClubQuest(clubQuest);
    }
}
