package com.example.daedongyeojido_server.domain.mess.domain;

import com.example.daedongyeojido_server.domain.club.domain.Club;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Mess {

    @Id
    @Column(name = "mess_id", nullable = false)
    private Long messId;

    @Column(name = "mess_start_time", length = 2, nullable = false)
    private Integer messStartTime;

    @Column(name = "mess_end_time", length = 2, nullable = false)
    private Integer messEndTime;

    @Column(name = "mess_agree", nullable = false)
    private Boolean messAgree;

    @Column(name = "mess_date", nullable = false)
    private LocalDate messDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "my_club")
    private Club myclub;

    @Builder
    public Mess(Long messId, Integer messStartTime, Integer messEndTime, Boolean messAgree, LocalDate messDate, Club myclub) {
        this.messId = messId;
        this.messStartTime = messStartTime;
        this.messEndTime = messEndTime;
        this.messAgree = messAgree;
        this.messDate = messDate;
        this.myclub = myclub;
    }
}