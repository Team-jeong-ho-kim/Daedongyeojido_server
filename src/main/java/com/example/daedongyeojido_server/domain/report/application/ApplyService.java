package com.example.daedongyeojido_server.domain.report.application;

import com.example.daedongyeojido_server.domain.notice.dao.NoticeRepository;
import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import com.example.daedongyeojido_server.domain.notice.exception.NoticeNotFoundException;
import com.example.daedongyeojido_server.domain.report.dao.ReportRepository;
import com.example.daedongyeojido_server.domain.report.domain.Report;
import com.example.daedongyeojido_server.domain.report.dto.request.ApplyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ApplyService {

    private final ReportRepository reportRepository;

    private final NoticeRepository noticeRepository;

    @Transactional
    public void apply(ApplyRequest request) {
        Notice notice = noticeRepository.findById(request.getNoticeId())
                .orElseThrow(()-> NoticeNotFoundException.EXCEPTION);

        reportRepository.save(
                Report.builder()
                        .classNumber(request.getClassNumber())
                        .name(request.getName())
                        .oneLiner(request.getOneLiner())
                        .introduction(request.getIntroduction())
                        .hopeMajor(request.getHopeMajor())
                        .learn(request.getLearn())
                        .notice(notice)
                        .build());
    }
}