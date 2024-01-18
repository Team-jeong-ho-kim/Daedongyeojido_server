package com.example.daedongyeojido_server.domain.club.domain;

import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import com.example.daedongyeojido_server.domain.report.domain.Report;
import com.example.daedongyeojido_server.domain.user.domain.User;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Club {

    @Id
    @Column(name = "club_name", length = 20, nullable = false)
    private String clubName;

    @Column(name = "title", length = 30)
    private String title;

    @Column(name = "content", length = 300)
    private String content;

    @Column(name = "club_image_url", length = 20)
    private String clubImageUrl;

    @OneToMany(mappedBy = "club", orphanRemoval = true)
    private List<User> clubMembers = new ArrayList<>();

    @ElementCollection
    private List<String> tags = new ArrayList<>();

    @OneToMany(mappedBy = "club", orphanRemoval = true)
    private List<Notice> notices = new ArrayList<>();

    @OneToMany(mappedBy = "club", orphanRemoval = true)
    private List<Report> reports = new ArrayList<>();

    @Column(name = "mess_count", nullable = false)
    private Integer messCount = 0;
}
