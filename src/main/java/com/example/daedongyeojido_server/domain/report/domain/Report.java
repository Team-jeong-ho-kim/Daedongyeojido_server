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
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "passing_result", nullable = false)
    private PassingResult passingResult;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_id", nullable = false)
    private Notice notice;

    public void interviewResult(PassingResult passingResult) {
        this.passingResult = passingResult;
    }
}
