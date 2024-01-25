package com.example.daedongyeojido_server.domain.user.application;

import com.example.daedongyeojido_server.domain.user.domain.User;
import com.example.daedongyeojido_server.domain.user.dto.response.MyInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentInfoService {

    private final UserFacade userFacade;

    public MyInfoResponse studentInfo() {
        User user = userFacade.currentStudent();

        String clubName;
        if (user.getMyClub() == null) {
            clubName = "null";
        } else {
            clubName = user.getMyClub().getClubName();
        }

        return MyInfoResponse.builder()
                .classNumber(user.getClassNumber())
                .name(user.getName())
                .part(user.getPart())
                .myClub(clubName)
                .build();
    }
}
