package com.example.daedongyeojido_server.domain.Inquiry.dto.request;

import com.example.daedongyeojido_server.domain.Inquiry.domain.enums.InquiryType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InquiryRequest {

    @NotBlank
    @Size(min = 2, max = 4, message = "이름 2글자 이하, 4글자 이상이어야 합니다.")
    private String name;

    @NotBlank
    @Size(min = 11, max = 11, message = "핸드폰 번호는 11글자 이어야 합니다.")
    private String phoneNumber;

    @NotNull
    private InquiryType inquiryType;

    @NotBlank
    @Size(max = 300, message = "문의내용은 300글자 이하여야 합니다.")
    private String inquiryContent;
}
