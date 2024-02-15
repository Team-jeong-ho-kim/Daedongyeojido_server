package com.example.daedongyeojido_server.domain.user.application;

import com.example.daedongyeojido_server.domain.report.dao.ReportRepository;
import com.example.daedongyeojido_server.domain.user.domain.User;
import com.example.daedongyeojido_server.domain.user.dto.response.MyInfoResponse;
import com.example.daedongyeojido_server.domain.user.dto.response.MyReportResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MyInfoService {

    private final UserFacade userFacade;

    private final ReportRepository reportRepository;

    @Transactional(readOnly = true)
    public MyInfoResponse myInfo() {
        User user = userFacade.currentUser();

        String clubName;
        if (user.getMyClub() == null) {
            clubName = "null";
        } else {
            clubName = user.getMyClub().getClubName();
        }

        List<MyReportResponse> myReportResponses = reportRepository.findAllByClassNumber(user.getClassNumber())
                .stream()
                .map(MyReportResponse::new)
                .collect(Collectors.toList());

        return MyInfoResponse.builder()
                .classNumber(user.getClassNumber())
                .name(user.getName())
                .part(user.getPart())
                .myClub(clubName)
                .myReport(myReportResponses)
                .build();
    }
}
