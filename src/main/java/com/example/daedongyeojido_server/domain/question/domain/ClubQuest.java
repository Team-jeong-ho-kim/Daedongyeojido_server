package com.example.daedongyeojido_server.domain.question.domain;

import com.example.daedongyeojido_server.domain.club.domain.Club;
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
public class ClubQuest {

    @Id
    @Column(name = "club_quest_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clubQuestId;

    @Column(name = "question", nullable = false)
    private String question;

    @Column(name = "answer")
    private String answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_name", nullable = false)
    private Club club;

    public void answerQuestion(String answer) {
        this.answer = answer;
    }
}
