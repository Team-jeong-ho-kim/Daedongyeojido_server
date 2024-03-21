package com.example.daedongyeojido_server.domain.notice.dto.response;

import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NoticeResponse {

    private Long id;

    private String clubName;

    private String noticeTitle;

    private StartAndEndTimeResponse recruitDay;

    private String clubImageUrl;

    public NoticeResponse(Notice notice) {
        id = notice.getNoticeId();
        clubName = notice.getClubName().getClubName();
        recruitDay = new StartAndEndTimeResponse(notice.getRecruitDay().getStartDay(), notice.getRecruitDay().getEndDay());
        clubImageUrl = notice.getClubName().getClubImageUrl();
    }
}