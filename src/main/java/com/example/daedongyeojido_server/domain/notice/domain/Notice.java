package com.example.daedongyeojido_server.domain.notice.domain;

import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.report.domain.Report;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

    @Column(name = "notice_title", nullable = false)
    private String noticeTitle;

    @Column(name = "notice_explain", nullable = false)
    private String noticeExplain;

    @Column(name = "club_explain", nullable = false)
    private String clubExplain;

    @Column(name = "apply_method", nullable = false)
    private String applyMethod;

    @Column(name = "inquiry", nullable = false)
    private String inquiry;

    @Column(name = "we_want", nullable = false)
    private String weWant;

    @Column(name = "assignment", nullable = false)
    private String assignment;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "club")
    private Club clubName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interview_day")
    private StartAndEndTime interviewDay;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recruit_day")
    private StartAndEndTime recruitDay;

    @OneToMany(mappedBy = "notice", orphanRemoval = true, cascade = CascadeType.REMOVE)
    private List<Field> fields = new ArrayList<>();

    @OneToMany(mappedBy = "notice", orphanRemoval = true)
    private List<Report> reports;

    @OneToMany(mappedBy = "notice", orphanRemoval = true)
    private List<NoticeQuest> noticeQuests;

    public void setRecruitDay(StartAndEndTime startAndEndTime) {
        this.recruitDay = startAndEndTime;
    }

    public void setInterviewDay(StartAndEndTime startAndEndTime) {
        this.interviewDay = startAndEndTime;
    }

    public void addQuest(NoticeQuest noticeQuest) {
        this.noticeQuests.add(noticeQuest);
    }

    public void updateNotice(String noticeTitle, String noticeExplain, String clubExplain,
                             String applyMethod, String inquiry, String weWant, String assignment) {
        this.noticeTitle = noticeTitle;
        this.noticeExplain = noticeExplain;
        this.clubExplain = clubExplain;
        this.applyMethod = applyMethod;
        this.inquiry = inquiry;
        this.weWant = weWant;
        this.assignment = assignment;
    }

    public void addField(Field field) {
        this.fields.add(field);
    }
}
