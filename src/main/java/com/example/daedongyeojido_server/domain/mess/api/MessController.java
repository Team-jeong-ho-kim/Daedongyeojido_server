package com.example.daedongyeojido_server.domain.mess.api;

import com.example.daedongyeojido_server.domain.mess.application.AcceptMessService;
import com.example.daedongyeojido_server.domain.mess.application.CreateMessService;
import com.example.daedongyeojido_server.domain.mess.application.DeleteMessService;
import com.example.daedongyeojido_server.domain.mess.application.QueryMessService;
import com.example.daedongyeojido_server.domain.mess.dto.request.CreateMessRequest;
import com.example.daedongyeojido_server.domain.mess.dto.response.QueryMessResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mess")
public class MessController {

    private final CreateMessService createMessService;

    private final AcceptMessService acceptMessService;

    private final QueryMessService queryMessService;

    private final DeleteMessService deleteMessService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void createMess(@RequestBody @Valid CreateMessRequest request) {
        createMessService.createMess(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/accept/{messId}")
    public void acceptMess(@PathVariable Long messId) {
        acceptMessService.acceptMess(messId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    public List<QueryMessResponse> queryMess() {
        return queryMessService.queryMess();
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{messId}")
    public void deleteMess(@PathVariable Long messId) {
        deleteMessService.deleteMess(messId);
    }
}