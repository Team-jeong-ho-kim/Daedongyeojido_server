package com.example.daedongyeojido_server.domain.club.admin.application;

import com.example.daedongyeojido_server.domain.club.admin.dto.request.ClubMemberRequest;
import com.example.daedongyeojido_server.domain.club.admin.dto.request.EditClubMemberRequest;
import com.example.daedongyeojido_server.domain.club.common.dao.ClubRepository;
import com.example.daedongyeojido_server.domain.club.common.domain.Club;
import com.example.daedongyeojido_server.domain.user.dao.UserRepository;
import com.example.daedongyeojido_server.domain.user.domain.User;
import com.example.daedongyeojido_server.domain.user.domain.enums.Part;
import com.example.daedongyeojido_server.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EditClubMemberService {

    private final ClubRepository clubRepository;

    private final UserRepository userRepository;

    @Transactional
    public void editClubMember(EditClubMemberRequest request) {
        Club club = clubRepository.findByClubName(request.getClubName());

            if (userRepository.findByName(request.getTeacherName()).isPresent()) {
            User teacher = userRepository.findByName(request.getTeacherName())
                    .orElseThrow(() -> UserNotFoundException.EXCEPTION);

            teacher.addClubMember(teacher.getPart(), club);
            club.editClubTeacher(teacher);
        }

        for (int i = 0; i < club.getClubMembers().size(); i++) {
            club.getClubMembers().get(i).addClubMember(Part.INDEPENDENT, null);
        }

        List<User> clubMembers = new ArrayList<>();

        for (int i = 0; i < request.getClubMembers().size(); i++) {
            ClubMemberRequest clubMemberRequest = request.getClubMembers().get(i);

            User student = userRepository.findByClassNumber(clubMemberRequest.getClassNumber())
                    .orElseThrow(() -> UserNotFoundException.EXCEPTION);

            clubMembers.add(student);
            student.addClubMember(clubMemberRequest.getPart(), club);
        }

        club.modifyMember(clubMembers);
    }
}