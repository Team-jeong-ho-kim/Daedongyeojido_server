package com.example.daedongyeojido_server.domain.report.domain;

import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import com.example.daedongyeojido_server.domain.report.domain.enums.PassingResult;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id", nullable = false)
    private Long reportId;

    @Column(name = "class_number", length = 4, nullable = false)
    private String classNumber;

    @Column(name = "name", length = 4, nullable = false)
    private String name;

    @Column(name = "one_liner", length = 20, nullable = false)
    private String oneLiner;

    @Column(name = "introduction", length = 100, nullable = false)
    private String introduction;

    @Column(name = "hope_major", length = 100, nullable = false)
    private String hopeMajor;

    @Column(name = "learn", length = 100, nullable = false)
    private String learn;

    @Column(name = "memo")
    private String memo;

    @Column(name = "interview_start_time")
    private LocalDateTime interviewStartTime;

    @Column(name = "interview_end_time")
    private LocalDateTime interviewEndTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "report_passing_result", nullable = false)
    private PassingResult reportPassingResult;

    @Enumerated(EnumType.STRING)
    @Column(name = "interview_passing_result", nullable = false)
    private PassingResult interviewPassingResult;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_id", nullable = false)
    private Notice notice;

    public void reportResult(PassingResult passingResult) {
        this.reportPassingResult = passingResult;
    }

    public void interviewResult(PassingResult passingResult) {
        this.interviewPassingResult = passingResult;
    }

    public void modifyMemo(String memo) {
        this.memo = memo;
    }

    public void saveInterviewTime(LocalDateTime interviewStartTime, LocalDateTime interviewEndTime) {
        this.interviewStartTime = interviewStartTime;
        this.interviewEndTime = interviewEndTime;
    }
}