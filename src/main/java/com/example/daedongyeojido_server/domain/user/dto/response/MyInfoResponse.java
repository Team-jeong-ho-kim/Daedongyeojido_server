package com.example.daedongyeojido_server.domain.user.dto.response;

import com.example.daedongyeojido_server.domain.notice.domain.enums.Major;
import com.example.daedongyeojido_server.domain.user.domain.enums.Part;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class MyInfoResponse {

    private String classNumber;

    private String name;

    private Part part;

    private String myClub;

    private String profileImageUrl;

    private Major major;

    private List<MyReportResponse> myReport;
}