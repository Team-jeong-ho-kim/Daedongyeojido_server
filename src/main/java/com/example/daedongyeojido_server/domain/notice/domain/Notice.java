package com.example.daedongyeojido_server.domain.notice.domain;

import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.report.domain.Report;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id", nullable = false)
    private Long noticeId;

    @Column(name = "notice_title", nullable = false, length = 20)
    private String noticeTitle;

    @Column(name = "notice_explain", nullable = false, length = 30)
    private String noticeExplain;

    @Column(name = "club_explain", nullable = false, length = 100)
    private String clubExplain;

    @OneToMany(mappedBy = "notice", orphanRemoval = true)
    private List<Field> fields = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recruit_day")
    private StartAndEndTime recruitDay;

    @Column(name = "apply_method", nullable = false, length = 30)
    private String applyMethod;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interview_day")
    private StartAndEndTime interviewDay;

    @Column(name = "inquiry", nullable = false, length = 100)
    private String inquiry;

    @Column(name = "we_want", nullable = false, length = 200)
    private String weWant;

    @Column(name = "assignment", nullable = false, length = 200)
    private String assignment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_name", nullable = false)
    private Club clubName;

    @OneToMany(mappedBy = "notice", orphanRemoval = true)
    private List<Report> reports;

    public void setRecruitDay(StartAndEndTime startAndEndTime) {
        this.recruitDay = startAndEndTime;
    }

    public void setInterviewDay(StartAndEndTime startAndEndTime) {
        this.interviewDay = startAndEndTime;
    }
}