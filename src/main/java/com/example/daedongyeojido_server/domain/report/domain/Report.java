package com.example.daedongyeojido_server.domain.report.domain;

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

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    @Column(name = "class_number", length = 4, nullable = false)
    private String classNumber;

    @Column(name = "name", length = 4, nullable = false)
    private String name;

    @Column(name = "introduction", length = 100, nullable = false)
    private String introduction;

    @Column(name = "hope_major", length = 100, nullable = false)
    private String hopeMajor;

    @Column(name = "learn", length = 100, nullable = false)
    private String learn;

    @Column(name = "club_name", length = 20, nullable = false)
    private String clubName;
}
