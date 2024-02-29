package com.example.daedongyeojido_server.domain.report.exception;

import com.example.daedongyeojido_server.global.error.exception.BusinessException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class ReportNotFoundException extends BusinessException {

    public static final BusinessException EXCEPTION = new ReportNotFoundException();

    public ReportNotFoundException() {
        super(ErrorCode.REPORT_NOT_FOUND);
    }
}