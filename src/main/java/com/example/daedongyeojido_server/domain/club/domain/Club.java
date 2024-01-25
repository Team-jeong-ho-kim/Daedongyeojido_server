package com.example.daedongyeojido_server.domain.club.domain;

import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import com.example.daedongyeojido_server.domain.report.domain.Report;
import com.example.daedongyeojido_server.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
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

    @OneToMany(mappedBy = "myClub",fetch = FetchType.EAGER, orphanRemoval = true)
    private List<User> clubMembers = new ArrayList<>();

    @ElementCollection
    private List<String> tags = new ArrayList<>();

    @OneToMany(mappedBy = "clubName", orphanRemoval = true)
    private List<Notice> notices = new ArrayList<>();

    @OneToMany(mappedBy = "clubName", orphanRemoval = true)
    private List<Report> reports = new ArrayList<>();

    @Column(name = "mess_count")
    private Integer messCount = 0;

//    @OneToMany(mappedBy = "clubName", orphanRemoval = true)
//    private

    @Builder
    public Club(String clubName) {
        this.clubName = clubName;
    }

    public void addMember(User user) {
        this.clubMembers.add(user);
    }

    public void modifyClub(String clubName, String title, String content, String clubImageUrl, List<User> clubMembers, List<String> tags, List<Notice> notices) {
        this.clubName = clubName;
        this.title = title;
        this.content = content;
        this.clubImageUrl = clubImageUrl;
        this.clubMembers = clubMembers;
        this.tags = tags;
        this.notices = notices;
    }

//    public void addMessCounts() {
//        this.messCount += 1;
//    }
}