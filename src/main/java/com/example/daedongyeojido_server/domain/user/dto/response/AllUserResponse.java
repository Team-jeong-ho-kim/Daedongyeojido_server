package com.example.daedongyeojido_server.domain.user.dto.response;

import com.example.daedongyeojido_server.domain.user.domain.User;
import com.example.daedongyeojido_server.domain.user.domain.enums.Part;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AllUserResponse {

    private String classNumber;

    private String name;

    private Part part;

    private String myClub;

    public AllUserResponse(User user) {
        if(user.getMyClub() == null) {
            myClub = "null";
        }
        else {
            myClub = user.getMyClub().getClubName();
        }

        classNumber = user.getClassNumber();
        name = user.getName();
        part = user.getPart();
    }
}
