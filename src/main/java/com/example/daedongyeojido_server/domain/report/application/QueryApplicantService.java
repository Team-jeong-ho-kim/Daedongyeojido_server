package com.example.daedongyeojido_server.domain.report.application;

import com.example.daedongyeojido_server.domain.club.dao.ClubRepository;
import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.club.exception.ClubMisMatchException;
import com.example.daedongyeojido_server.domain.report.dao.CustomReportRepository;
import com.example.daedongyeojido_server.domain.report.dto.response.ReportResponse;
import com.example.daedongyeojido_server.domain.user.application.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryApplicantService {

    private final ClubRepository clubRepository;

    private final UserFacade userFacade;

    private final CustomReportRepository customReportRepository;

    @Transactional(readOnly = true)
    public List<ReportResponse> queryApplicant(String clubName) {
        Club club = clubRepository.findByClubName(clubName);

        if(userFacade.currentUser().getMyClub() != club) throw ClubMisMatchException.EXCEPTION;

        return customReportRepository.findClubReport(club)
                .stream()
                .map(ReportResponse::new)
                .collect(Collectors.toList());
    }
}