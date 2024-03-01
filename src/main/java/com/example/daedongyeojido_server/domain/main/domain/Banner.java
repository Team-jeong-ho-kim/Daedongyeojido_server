package com.example.daedongyeojido_server.domain.main.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "banner_title", nullable = false)
    private String bannerTitle;

    @Column(name = "banner_img_url", nullable = false, columnDefinition = "TEXT")
    private String bannerImgUrl;
}