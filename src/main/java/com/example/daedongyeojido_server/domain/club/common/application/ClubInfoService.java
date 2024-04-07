package com.example.daedongyeojido_server.domain.club.common.application;

import com.example.daedongyeojido_server.domain.club.common.dto.response.ClubInfoResponse;
import com.example.daedongyeojido_server.domain.club.common.dto.response.ClubMemberResponse;
import com.example.daedongyeojido_server.domain.club.dao.ClubRepository;
import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.question.dao.QuestionRepository;
import com.example.daedongyeojido_server.domain.question.dto.response.QuestResponse;
import com.example.daedongyeojido_server.domain.user.dao.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClubInfoService {

    private final ClubRepository clubRepository;

    private final QuestionRepository questionRepository;

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public ClubInfoResponse clubInfo(String clubName) {

        Club club = clubRepository.findByClubName(clubName);

        List<ClubMemberResponse> clubMemberResponses = userRepository.findAllByMyClub(club)
                .stream()
                .map(ClubMemberResponse::new)
                .collect(Collectors.toList());

        List<QuestResponse> questResponses = questionRepository.findAllByClub(club)
                .stream()
                .map(QuestResponse::new)
                .collect(Collectors.toList());

        return ClubInfoResponse.builder()
                .clubName(club.getClubName())
                .title(club.getTitle())
                .introduction(club.getIntroduction())
                .clubImageUrl(club.getClubImageUrl())
                .clubBannerUrl(club.getClubBannerUrl())
                .tags(club.getTags())
                .teacherName((club.getTeacher() == null) ? "null" : club.getTeacher().getName())
                .clubMembers(clubMemberResponses)
                .questResponses(questResponses)
                .build();
    }
}