package com.example.daedongyeojido_server.domain.club.domain;

import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import com.example.daedongyeojido_server.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "introduction", length = 500)
    private String introduction;

    @Column(name = "project", length = 300)
    private String project;

    @Column(name = "we_want", length = 300)
    private String weWant;

    @Column(name = "q_and_a", length = 300)
    private String qAndA;

    @Column(name = "club_image_url", length = 20)
    private String clubImageUrl;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher")
    private User teacher;

    @OneToMany(mappedBy = "myClub", orphanRemoval = true)
    private List<User> clubMembers = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> tags = new ArrayList<>();

    @OneToMany(mappedBy = "clubName", orphanRemoval = true)
    private List<Notice> notices = new ArrayList<>();

    @Column(name = "mess_count")
    private Integer messCount = 0;

    public void addMember(User user) {
        this.clubMembers.add(user);
    }

    public void addNotice(Notice notice) {
        this.notices.add(notice);
    }

    public void modifyClub(String title, String introduction, String project, String weWant, String qAndA, String clubImageUrl) {
        this.title = title;
        this.introduction = introduction;
        this.project = project;
        this.weWant = weWant;
        this.qAndA = qAndA;
        this.clubImageUrl = clubImageUrl;
    }
}