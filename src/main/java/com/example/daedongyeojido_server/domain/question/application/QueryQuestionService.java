package com.example.daedongyeojido_server.domain.question.application;

import com.example.daedongyeojido_server.domain.club.dao.ClubRepository;
import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.club.exception.ClubMisMatchException;
import com.example.daedongyeojido_server.domain.question.dao.QuestionRepository;
import com.example.daedongyeojido_server.domain.question.dto.response.QuestResponse;
import com.example.daedongyeojido_server.domain.user.application.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryQuestionService {

    private final ClubRepository clubRepository;

    private final UserFacade userFacade;

    private final QuestionRepository questionRepository;

    @Transactional(readOnly = true)
    public List<QuestResponse> queryQuestion(String clubName) {
        Club club = clubRepository.findByClubName(clubName);

        if(userFacade.currentUser().getMyClub() != club) throw ClubMisMatchException.EXCEPTION;

        return questionRepository.findAllByClub(club)
                .stream()
                .map(QuestResponse::new)
                .collect(Collectors.toList());
    }
}
