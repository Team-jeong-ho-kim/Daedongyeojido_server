package com.example.daedongyeojido_server.domain.Inquiry.dao;

import com.example.daedongyeojido_server.domain.Inquiry.domain.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
}
