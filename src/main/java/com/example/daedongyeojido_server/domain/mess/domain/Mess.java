package com.example.daedongyeojido_server.domain.mess.domain;

import com.example.daedongyeojido_server.domain.club.domain.Club;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Mess {

    @Id
    @Column(name = "mess_id", nullable = false)
    private Long messId;

    @Column(name = "mess_start_time", length = 2, nullable = false)
    private Integer messStartTime;

    @Column(name = "mess_end_time", length = 2, nullable = false)
    private Integer messEndTime;

    @Column(name = "mess_date", nullable = false)
    private LocalDate messDate;

    @Column(name = "math_accept")
    private Integer MessAccept = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "my_club")
    private Club myclub;

    @Builder
    public Mess(Long messId, Integer messStartTime, Integer messEndTime, LocalDate messDate, Club myclub) {
        this.messId = messId;
        this.messStartTime = messStartTime;
        this.messEndTime = messEndTime;
        this.messDate = messDate;
        this.myclub = myclub;
    }

    public void acceptOrCancelMess(int i) {
        this.MessAccept += i;
    }
}