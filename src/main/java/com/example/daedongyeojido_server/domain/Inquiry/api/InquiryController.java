package com.example.daedongyeojido_server.domain.Inquiry.api;

import com.example.daedongyeojido_server.domain.Inquiry.application.CreateInquiryService;
import com.example.daedongyeojido_server.domain.Inquiry.dto.request.InquiryRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inquiry")
public class InquiryController {

    private final CreateInquiryService createInquiryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void createInquiry(@RequestBody @Valid InquiryRequest request) {
        createInquiryService.createInquiry(request);
    }
}
