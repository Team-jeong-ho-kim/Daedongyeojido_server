package com.example.daedongyeojido_server.domain.report.dao;

import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import com.example.daedongyeojido_server.domain.report.domain.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findAllByClassNumberAndNotice(String classNumber, Notice notice);
    List<Report> findAllByClassNumber(String classNumber);
}
