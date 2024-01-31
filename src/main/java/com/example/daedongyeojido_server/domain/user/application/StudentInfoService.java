package com.example.daedongyeojido_server.domain.user.application;

import com.example.daedongyeojido_server.domain.report.dao.CustomReportRepository;
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
public class StudentInfoService {

    private final UserFacade userFacade;

    private final CustomReportRepository customReportRepository;

    @Transactional
    public MyInfoResponse studentInfo() {
        User user = userFacade.currentStudent();

        String clubName;
        if (user.getMyClub() == null) {
            clubName = "null";
        } else {
            clubName = user.getMyClub().getClubName();
        }

        List<MyReportResponse> myReportResponses = customReportRepository.findMyReport(user)
                .stream()
                .map(MyReportResponse::new)
                .collect(Collectors.toList());

        return MyInfoResponse.builder()
                .classNumber(user.getClassNumber())
                .name(user.getName())
                .part(user.getPart())
                .myClub(clubName)
                .myReportResponses(myReportResponses)
                .build();
    }
}
