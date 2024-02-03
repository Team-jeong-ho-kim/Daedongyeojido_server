package com.example.daedongyeojido_server.domain.mess.domain;

import com.example.daedongyeojido_server.domain.club.domain.Club;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Mess {

    @Id
    @Column(name = "mess_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messId;

    @Column(name = "mess_start_time", nullable = false)
    private Integer messStartTime;

    @Column(name = "mess_end_time", nullable = false)
    private Integer messEndTime;

    @Column(name = "mess_date", nullable = false)
    private LocalDate messDate;

    @Column(name = "math_accept")
    private Integer MessAccept = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "my_club", nullable = false)
    private Club myClub;

    public void acceptOrCancelMess(int i) {
        this.MessAccept += i;
    }
}