package com.example.daedongyeojido_server.domain.mess.dto.response;

import com.example.daedongyeojido_server.domain.mess.domain.Mess;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class QueryMessResponse {

    private Long messId;

    private Integer messStartTime;

    private Integer messEndTime;

    private LocalDate messDate;

    private String myClub;

    public QueryMessResponse(Mess mess) {
        messStartTime = mess.getMessStartTime();
        messEndTime = mess.getMessEndTime();
        messDate = mess.getMessDate();
        myClub = mess.getMyClub().getClubName();
        messId = mess.getMessId();
    }
}