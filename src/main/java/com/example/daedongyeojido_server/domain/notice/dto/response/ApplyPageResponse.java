package com.example.daedongyeojido_server.domain.notice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ApplyPageResponse {

    private String name;

    private String classNumber;

    private List<MajorResponse> majors;

    private List<NoticeQuestResponse> questions;
}