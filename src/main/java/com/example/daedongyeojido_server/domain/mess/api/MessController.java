package com.example.daedongyeojido_server.domain.mess.api;

import com.example.daedongyeojido_server.domain.mess.application.CreateMessService;
import com.example.daedongyeojido_server.domain.mess.application.DeleteMessService;
import com.example.daedongyeojido_server.domain.mess.dto.request.CreateMessRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/jung-ho/mess")
@RestController
public class MessController {

    private final DeleteMessService deleteMessService;
    private final CreateMessService createMessService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/ask")
    public void createMess(@RequestBody @Valid CreateMessRequest request) {
        createMessService.createMess(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/cancel")
    public void deleteMess(@PathVariable Long messId) {
        deleteMessService.deleteMess(messId);
    }
}