package com.example.daedongyeojido_server.domain.announcement.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long announcementId;

    @Column(name = "title", length = 20, nullable = false)
    private String title;

    @Column(name = "contents", length = 200, nullable = false)
    private String contents;

    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;
}