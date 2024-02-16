package com.example.daedongyeojido_server.domain.club.admin.application;

import com.example.daedongyeojido_server.domain.club.admin.dto.request.ClubMemberRequest;
import com.example.daedongyeojido_server.domain.club.admin.dto.request.EditClubMemberRequest;
import com.example.daedongyeojido_server.domain.club.common.dao.ClubRepository;
import com.example.daedongyeojido_server.domain.club.common.domain.Club;
import com.example.daedongyeojido_server.domain.user.dao.UserRepository;
import com.example.daedongyeojido_server.domain.user.domain.User;
import com.example.daedongyeojido_server.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EditClubMemberService {

    private final ClubRepository clubRepository;

    private final UserRepository userRepository;

    @Transactional
    public void editClubMember(EditClubMemberRequest request) {
        Club club = clubRepository.findByClubName(request.getClubName());

        User teacher = userRepository.findByName(request.getTeacherName())
                        .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        for(int i=0; i<request.getClubMembers().size(); i++) {
            ClubMemberRequest clubMemberRequest = request.getClubMembers().get(i);

            User student = userRepository.findByClassNumber(clubMemberRequest.getClassNumber())
                            .orElseThrow(()->UserNotFoundException.EXCEPTION);

            club.addMember(student);
            student.addClubMember(clubMemberRequest.getName(), clubMemberRequest.getPart(), club);
        }

        club.editClubTeacher(teacher);
    }
}