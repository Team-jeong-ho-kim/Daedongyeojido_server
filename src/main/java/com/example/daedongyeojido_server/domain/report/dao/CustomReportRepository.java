package com.example.daedongyeojido_server.domain.report.dao;

import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.report.domain.Report;

import java.util.List;

public interface CustomReportRepository {
    List<Report> findClubReport(Club club);
}