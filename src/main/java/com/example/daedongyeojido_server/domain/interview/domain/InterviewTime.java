package com.example.daedongyeojido_server.domain.interview.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InterviewTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interview_time_id", nullable = false)
    private Long interviewTimeId;

    @Column(name = "interview_start_time", nullable = false)
    private LocalDateTime interviewStartTime;

    @Column(name = "interview_end_time", nullable = false)
    private LocalDateTime interviewEndTime;


    @Column(name = "club_name", nullable = false)
    private String clubName;
}
