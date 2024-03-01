package com.example.daedongyeojido_server.domain.report.api;

import com.example.daedongyeojido_server.domain.report.application.*;
import com.example.daedongyeojido_server.domain.report.dto.request.ApplyRequest;
import com.example.daedongyeojido_server.domain.report.dto.request.MemoRequest;
import com.example.daedongyeojido_server.domain.report.dto.response.ApplyPageResponse;
import com.example.daedongyeojido_server.domain.report.dto.response.MemoResponse;
import com.example.daedongyeojido_server.domain.report.dto.response.ReportInfoResponse;
import com.example.daedongyeojido_server.domain.report.dto.response.ReportResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
public class ReportController {

    private final ApplyService applyService;

    private final QueryApplyPageService queryApplyPageService;

    private final QueryApplicantService queryReportService;

    private final ReportInfoService reportInfoService;

    private final QueryMemoService queryMemoService;

    private final ModifyMemoService modifyMemoService;

    private final CancelApplyService cancelApplyService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/apply")
    public void apply(@RequestBody @Valid ApplyRequest request) {
        applyService.apply(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/apply/{noticeId}")
    public ApplyPageResponse queryApplyPage(@PathVariable Long noticeId) {
        return queryApplyPageService.queryApplyPage(noticeId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/applicant/{clubName}")
    public List<ReportResponse> queryApplicant(@PathVariable String clubName) {
        return queryReportService.queryApplicant(clubName);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/report-info/{reportId}")
    public ReportInfoResponse reportInfo(@PathVariable Long reportId) {
        return reportInfoService.reportInfo(reportId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/query-memo/{reportId}")
    public MemoResponse queryMemo(@PathVariable Long reportId) {
        return queryMemoService.queryMemo(reportId);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/modify-memo")
    public void modifyMemo(@RequestBody @Valid MemoRequest request) {
        modifyMemoService.modifyMemo(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/cancel/{reportId}")
    public void cancelApply(@PathVariable Long reportId) {
        cancelApplyService.cancelApply(reportId);
    }
}