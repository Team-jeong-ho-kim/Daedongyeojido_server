package com.example.daedongyeojido_server.domain.notice.dto.response;

import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import com.example.daedongyeojido_server.domain.notice.domain.enums.Major;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class NoticeResponse {

    private Long id;

    private Major major;

    private String clubName;

    private LocalDateTime deadline;

    private Boolean applyOrNot;

    public NoticeResponse(Notice notice) {
        id = notice.getNoticeId();
        major = notice.getMajor();
        clubName = notice.getClubName().getClubName();
        deadline = notice.getDeadline();
        applyOrNot = false;
    }

    public void apply() {
        this.applyOrNot = true;
    }
}

