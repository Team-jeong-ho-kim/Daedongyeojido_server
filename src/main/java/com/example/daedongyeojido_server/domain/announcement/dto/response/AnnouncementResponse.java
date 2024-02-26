package com.example.daedongyeojido_server.domain.announcement.dto.response;

import com.example.daedongyeojido_server.domain.announcement.domain.Announcement;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AnnouncementResponse {

    private String title;

    private String contents;

    private LocalDateTime createTime;

    public AnnouncementResponse(Announcement announcement) {
        title = announcement.getTitle();
        contents = announcement.getContents();
        createTime = announcement.getCreateTime();
    }
}