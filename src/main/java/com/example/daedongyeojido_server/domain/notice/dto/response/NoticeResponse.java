package com.example.daedongyeojido_server.domain.notice.dto.response;

import com.example.daedongyeojido_server.domain.notice.domain.Field;
import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import com.example.daedongyeojido_server.domain.notice.domain.enums.Major;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class NoticeResponse {

    private Long id;

    private String clubName;

    private String noticeTitle;

    private List<Major> major;

    private StartAndEndTimeResponse recruitDay;

    private Boolean isApply = false;

    public NoticeResponse(Notice notice) {
        id = notice.getNoticeId();
        clubName = notice.getClubName().getClubName();
        noticeTitle = notice.getNoticeTitle();
        major = notice.getFields().stream().map(Field::getMajor).toList();
        recruitDay = new StartAndEndTimeResponse(notice.getRecruitDay().getStartDay(), notice.getRecruitDay().getEndDay());
    }

    public void apply() {
        isApply = true;
    }
}