package com.example.daedongyeojido_server.domain.announcement.dao;

import com.example.daedongyeojido_server.domain.announcement.domain.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
}