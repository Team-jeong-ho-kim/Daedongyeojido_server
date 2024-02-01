package com.example.daedongyeojido_server.domain.user.api;

import com.example.daedongyeojido_server.domain.user.application.AddClubMemberService;
import com.example.daedongyeojido_server.domain.user.application.StudentInfoService;
import com.example.daedongyeojido_server.domain.user.application.TeacherInfoService;
import com.example.daedongyeojido_server.domain.user.dto.request.AddClubMemberRequest;
import com.example.daedongyeojido_server.domain.user.dto.response.MyInfoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jung-ho/user")
public class UserController {

    private final StudentInfoService studentInfoService;

    private final TeacherInfoService teacherInfoService;

    private final AddClubMemberService addClubMemberService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/student-info")
    public MyInfoResponse studentInfo() {
        return studentInfoService.studentInfo();
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/teacher-info")
    public MyInfoResponse teacherInfo() {
        return teacherInfoService.teacherInfo();
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/member")
    public void addClubMember(@RequestBody @Valid AddClubMemberRequest request) {
        addClubMemberService.AddClubMember(request);
    }
}
