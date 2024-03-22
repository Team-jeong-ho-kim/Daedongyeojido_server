package com.example.daedongyeojido_server.domain.report.domain;

import com.example.daedongyeojido_server.domain.notice.domain.Field;
import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import com.example.daedongyeojido_server.domain.report.domain.enums.PassingResult;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private List<ReportQuest> reportQuests = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice", nullable = false)
    private Notice notice;
}