package com.example.daedongyeojido_server.domain.report.api;

import com.example.daedongyeojido_server.domain.report.application.ApplyService;
import com.example.daedongyeojido_server.domain.report.dto.request.ApplyRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jung-ho/report")
public class ReportController {

    private final ApplyService applyService;

    @PostMapping("/apply")
    public void apply(@RequestBody @Valid ApplyRequest request) {
        applyService.apply(request);
    }
}
