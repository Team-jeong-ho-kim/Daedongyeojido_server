package com.example.daedongyeojido_server.domain.report.dao;

import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.report.domain.Report;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.daedongyeojido_server.domain.report.domain.QReport.report;

@Repository
@RequiredArgsConstructor
public class CustomReportRepositoryImpl implements CustomReportRepository {

    private final JPAQueryFactory queryFactory;

    public List<Report> findClubReport(Club club) {
        return queryFactory
                .selectFrom(report)
                .where(report.notice.clubName.eq(club))
                .fetch();
    }
}
