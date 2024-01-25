package com.example.daedongyeojido_server.domain.notice.dto.response;

import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import com.example.daedongyeojido_server.domain.notice.domain.enums.Major;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class NoticeResponse {

    private Major major;

    private String clubName;

    private LocalDateTime deadline;

    public NoticeResponse(Notice notice) {
        major = notice.getMajor();
        clubName = notice.getClubName().getClubName();
        deadline = notice.getDeadline();
    }
}

