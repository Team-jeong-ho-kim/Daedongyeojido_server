package com.example.daedongyeojido_server.domain.club.domain;

import com.example.daedongyeojido_server.domain.notice.domain.Notice;
import com.example.daedongyeojido_server.domain.question.domain.ClubQuest;
import com.example.daedongyeojido_server.domain.user.domain.User;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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

    @Column(name = "introduction", length = 500)
    private String introduction;

    @Column(name = "club_image_url", length = 20, columnDefinition = "TEXT")
    private String clubImageUrl;

    @Column(name = "club_banner_url", columnDefinition = "TEXT")
    private String clubBannerUrl;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher")
    private User teacher;

    @OneToMany(mappedBy = "myClub", orphanRemoval = true)
    private List<User> clubMembers = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> tags = new ArrayList<>();

    @OneToMany(mappedBy = "clubName", orphanRemoval = true)
    private List<Notice> notices = new ArrayList<>();

    @OneToMany
    private List<ClubQuest> clubQuests = new ArrayList<>();

    @Column(name = "mess_count")
    private Integer messCount = 0;

    public void modifyMember(List<User> clubMembers) {
        this.clubMembers.clear();
        this.clubMembers.addAll(clubMembers);
    }

    public void addNotice(Notice notice) {
        this.notices.add(notice);
    }

    public void addClubQuest(ClubQuest clubQuest) {
        this.clubQuests.add(clubQuest);
    }

    public void modifyClub(String title, String introduction, String clubImageUrl, String clubBannerUrl, List<String> tags) {
        this.title = title;
        this.introduction = introduction;
        this.clubImageUrl = clubImageUrl;
        this.clubBannerUrl = clubBannerUrl;
        this.tags = tags;
    }

    public void editClubTeacher(User teacher) {
        this.teacher = teacher;
    }
}