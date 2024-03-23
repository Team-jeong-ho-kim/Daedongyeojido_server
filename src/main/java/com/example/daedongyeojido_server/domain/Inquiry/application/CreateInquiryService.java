package com.example.daedongyeojido_server.domain.Inquiry.application;

import com.example.daedongyeojido_server.domain.Inquiry.dao.InquiryRepository;
import com.example.daedongyeojido_server.domain.Inquiry.domain.Inquiry;
import com.example.daedongyeojido_server.domain.Inquiry.dto.request.InquiryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateInquiryService {

    private final InquiryRepository inquiryRepository;

    @Transactional
    public void createInquiry(InquiryRequest request) {
        inquiryRepository.save(
                Inquiry.builder()
                        .name(request.getName())
                        .phoneNumber(request.getPhoneNumber())
                        .inquiryType(request.getInquiryType())
                        .inquiryContent(request.getInquiryContent())
                        .build());
    }
}
