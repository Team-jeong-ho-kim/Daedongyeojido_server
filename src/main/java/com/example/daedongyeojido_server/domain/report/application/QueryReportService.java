package com.example.daedongyeojido_server.domain.report.application;

import com.example.daedongyeojido_server.domain.club.dao.ClubRepository;
import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.report.dao.CustomReportRepository;
import com.example.daedongyeojido_server.domain.report.dto.response.ReportResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryReportService {

    private final ClubRepository clubRepository;

    private final CustomReportRepository customReportRepository;

    @Transactional
    public List<ReportResponse> queryReport(String clubName) {
        Club club = clubRepository.findByClubName(clubName);

        return customReportRepository.findClubReport(club)
                .stream()
                .map(ReportResponse::new)
                .collect(Collectors.toList());
    }
}
