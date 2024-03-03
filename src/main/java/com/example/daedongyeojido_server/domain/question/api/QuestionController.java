package com.example.daedongyeojido_server.domain.question.api;

import com.example.daedongyeojido_server.domain.question.application.QuestClubService;
import com.example.daedongyeojido_server.domain.question.dto.request.QuestRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {

    private final QuestClubService questClubService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/quest")
    public void questClub(@RequestBody @Valid QuestRequest request) {
        questClubService.questClub(request);
    }
}
