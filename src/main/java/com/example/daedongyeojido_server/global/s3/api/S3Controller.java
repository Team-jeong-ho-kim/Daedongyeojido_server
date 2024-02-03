package com.example.daedongyeojido_server.global.s3.api;

import com.example.daedongyeojido_server.global.s3.dto.response.ImageUrlResponse;
import com.example.daedongyeojido_server.global.s3.service.CreateImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/aster")
public class S3Controller {

    private final CreateImageService createImageService;

    @PostMapping("/image")
    public ImageUrlResponse createImage(@RequestPart(value = "image", required = false) MultipartFile multipartFiles) {
        return createImageService.createImage(multipartFiles);
    }
}
