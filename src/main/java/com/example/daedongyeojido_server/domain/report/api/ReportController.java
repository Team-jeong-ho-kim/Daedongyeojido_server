package com.example.daedongyeojido_server.domain.report.api;

import com.example.daedongyeojido_server.domain.report.application.ApplyService;
import com.example.daedongyeojido_server.domain.report.application.CancelApplyService;
import com.example.daedongyeojido_server.domain.report.application.QueryReportService;
import com.example.daedongyeojido_server.domain.report.dto.request.ApplyRequest;
import com.example.daedongyeojido_server.domain.report.dto.response.ReportResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jung-ho/report")
public class ReportController {

    private final ApplyService applyService;

    private final QueryReportService queryReportService;

    private final CancelApplyService cancelApplyService;

    @PostMapping("/apply")
    public void apply(@RequestBody @Valid ApplyRequest request) {
        applyService.apply(request);
    }

    @GetMapping("/query/{clubName}")
    public List<ReportResponse> queryReport(@PathVariable String clubName) {
        return queryReportService.queryReport(clubName);
    }

    @DeleteMapping("/cancel/{reportId}")
    public void cancelApply(@PathVariable Long reportId) {
        cancelApplyService.cancelApply(reportId);
    }
}
