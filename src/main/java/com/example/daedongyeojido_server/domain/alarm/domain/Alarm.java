package com.example.daedongyeojido_server.domain.alarm.domain;

import com.example.daedongyeojido_server.domain.alarm.domain.enums.AlarmType;
import com.example.daedongyeojido_server.domain.notice.domain.enums.Major;
import com.example.daedongyeojido_server.domain.report.domain.enums.PassingResult;
import com.example.daedongyeojido_server.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Alarm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alarmId;

    @Column(name = "title", length = 20)
    private String title;

    @Column(name = "contents", length = 200)
    private String contents;

    @Column(name = "club_name", length = 20)
    private String clubName;

    @Column(name = "user_name", length = 4)
    private String userName;

    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;

    @Column(name = "passing_result")
    @Enumerated(EnumType.STRING)
    private PassingResult passingResult;

    @Column(name = "major")
    @Enumerated(EnumType.STRING)
    private Major major;

    @Column(name = "alarm_type")
    @Enumerated(EnumType.STRING)
    private AlarmType alarmType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}