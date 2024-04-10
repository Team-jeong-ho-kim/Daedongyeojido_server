package com.example.daedongyeojido_server.domain.question.api;

import com.example.daedongyeojido_server.domain.question.application.AnswerQuestionService;
import com.example.daedongyeojido_server.domain.question.application.DeleteClubQuestService;
import com.example.daedongyeojido_server.domain.question.application.QueryQuestionService;
import com.example.daedongyeojido_server.domain.question.application.QuestClubService;
import com.example.daedongyeojido_server.domain.question.dto.request.AnswerRequest;
import com.example.daedongyeojido_server.domain.question.dto.request.QuestRequest;
import com.example.daedongyeojido_server.domain.question.dto.response.QuestResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {

    private final QuestClubService questClubService;

    private final AnswerQuestionService answerQuestionService;

    private final QueryQuestionService queryQuestionService;

    private final DeleteClubQuestService deleteClubQuestService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/quest")
    public void questClub(@RequestBody @Valid QuestRequest request) {
        questClubService.questClub(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/answer")
    public void answerQuest(@RequestBody @Valid AnswerRequest request) {
        answerQuestionService.answerQuest(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/query/{clubName}")
    public List<QuestResponse> queryQuest(@PathVariable String clubName) {
        return queryQuestionService.queryQuestion(clubName);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{clubQuestId}")
    public void deleteClubQuest(@PathVariable Long clubQuestId) {
        deleteClubQuestService.deleteClubQuest(clubQuestId);
    }
}
