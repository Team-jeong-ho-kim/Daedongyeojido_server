package com.example.daedongyeojido_server.domain.alarm.dto.response;

import com.example.daedongyeojido_server.domain.alarm.domain.Alarm;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AnnouncementResponse {

    private String title;

    private String contents;

    public AnnouncementResponse(Alarm announcement) {
        title = announcement.getTitle();
        contents = announcement.getContents();
    }
}