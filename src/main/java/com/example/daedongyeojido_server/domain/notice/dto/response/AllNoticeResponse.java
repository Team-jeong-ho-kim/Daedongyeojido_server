package com.example.daedongyeojido_server.domain.notice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class AllNoticeResponse {

    Boolean isCreateNotice;

    List<NoticeResponse> notices;
}
