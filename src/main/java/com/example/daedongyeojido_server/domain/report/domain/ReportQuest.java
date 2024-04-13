package com.example.daedongyeojido_server.domain.report.domain;

import com.example.daedongyeojido_server.domain.report.dto.request.SaveReportQuestRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class ReportQuest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

//    @Column(name = "question", nullable = false, length = 30)
//    private String question;
//
//    @Column(name = "answer", nullable = false, length = 200)
//    private String answer;

    @Column(name = "question_1", nullable = false)
    private String question1;

    @Column(name = "answer_1", nullable = false)
    private String answer1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report", nullable = false)
    private Report report;

    public ReportQuest(SaveReportQuestRequest request) {
        this.question1 = request.getQuestion();
        this.answer1 = request.getAnswer();
    }
}
