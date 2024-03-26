package com.example.daedongyeojido_server.domain.report.exception;

import com.example.daedongyeojido_server.global.error.exception.DaedongException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class ReportNotFoundException extends DaedongException {

    public static final DaedongException EXCEPTION = new ReportNotFoundException();

    public ReportNotFoundException() {
        super(ErrorCode.REPORT_NOT_FOUND);
    }
}