package com.example.daedongyeojido_server.domain.report.api;

import com.example.daedongyeojido_server.domain.report.application.ApplyService;
import com.example.daedongyeojido_server.domain.report.application.CancelApplyService;
import com.example.daedongyeojido_server.domain.report.application.ChooseInterviewTimeService;
import com.example.daedongyeojido_server.domain.report.application.ModifyMemoService;
import com.example.daedongyeojido_server.domain.report.application.QueryApplicantService;
import com.example.daedongyeojido_server.domain.report.application.QueryMemoService;
import com.example.daedongyeojido_server.domain.report.application.ReportInfoService;
import com.example.daedongyeojido_server.domain.report.dto.request.ApplyRequest;
import com.example.daedongyeojido_server.domain.report.dto.request.InterviewTimeRequest;
import com.example.daedongyeojido_server.domain.report.dto.request.MemoRequest;
import com.example.daedongyeojido_server.domain.report.dto.response.MemoResponse;
import com.example.daedongyeojido_server.domain.report.dto.response.ReportInfoResponse;
import com.example.daedongyeojido_server.domain.report.dto.response.ReportResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
public class ReportController {

    private final ApplyService applyService;

    private final ChooseInterviewTimeService chooseInterviewTImeService;

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
    @PostMapping("/interview-time")
    public void chooseInterviewTime(@RequestBody @Valid InterviewTimeRequest request) {
        chooseInterviewTImeService.chooseInterviewTime(request);
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
