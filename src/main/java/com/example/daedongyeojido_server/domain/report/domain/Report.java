package com.example.daedongyeojido_server.domain.report.domain;

import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import com.example.daedongyeojido_server.domain.report.domain.enums.PassingResult;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

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

    @Column(name = "introduce", length = 200, nullable = false)
    private String introduce;

    @OneToMany(mappedBy = "report", orphanRemoval = true)
    private List<ReportQuest> reportQuests;

    @Column(name = "memo")
    private String memo;

    @Column(name = "interview_start_time")
    private LocalDateTime interviewStartTime;

    @Column(name = "interview_end_time")
    private LocalDateTime interviewEndTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "report_passing_result")
    private PassingResult reportPassingResult;

    @Enumerated(EnumType.STRING)
    @Column(name = "interview_passing_result")
    private PassingResult interviewPassingResult;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice", nullable = false)
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

    public void addReportQuest(ReportQuest reportQuest) {
        this.reportQuests.add(reportQuest);
    }
}