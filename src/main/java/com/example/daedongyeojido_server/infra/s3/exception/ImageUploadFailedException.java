package com.example.daedongyeojido_server.infra.s3.exception;

import com.example.daedongyeojido_server.global.error.exception.BusinessException;
import com.example.daedongyeojido_server.global.error.exception.ErrorCode;

public class ImageUploadFailedException extends BusinessException {

    public static final BusinessException EXCEPTION =
            new ImageUploadFailedException();

    private ImageUploadFailedException() { super(ErrorCode.IMAGE_UPLOAD_FAIL);}
}
