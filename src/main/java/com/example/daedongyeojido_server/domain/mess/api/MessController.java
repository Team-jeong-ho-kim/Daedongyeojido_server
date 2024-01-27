package com.example.daedongyeojido_server.domain.mess.api;

import com.example.daedongyeojido_server.domain.mess.application.CreateMessService;
import com.example.daedongyeojido_server.domain.mess.application.DeleteMessService;
import com.example.daedongyeojido_server.domain.mess.application.QueryMessService;
import com.example.daedongyeojido_server.domain.mess.domain.Mess;
import com.example.daedongyeojido_server.domain.mess.dto.request.CreateMessRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jung-ho/mess")
public class MessController {

    private final CreateMessService createMessService;

    private final QueryMessService queryMessService;

    private final DeleteMessService deleteMessService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/create")
    public void createMess(@RequestBody @Valid CreateMessRequest request) {
        createMessService.createMess(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/query")
    public List<Mess> queryMess() {
        return queryMessService.queryMess();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{messId}")
    public void deleteMess(@PathVariable Long messId) {
        deleteMessService.deleteMess(messId);
    }
}