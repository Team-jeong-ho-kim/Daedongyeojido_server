package com.example.daedongyeojido_server.domain.user.domain;

import com.example.daedongyeojido_server.domain.alarm.domain.Alarm;
import com.example.daedongyeojido_server.domain.club.common.domain.Club;
import com.example.daedongyeojido_server.domain.user.domain.enums.Part;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(
            columnDefinition = "BINARY(16)",
            nullable = false
    )
    private UUID userId = UUID.randomUUID();

    @Column(name = "xquare_id", nullable = false)
    private String xquareId;

    @Column(name = "class_number", length = 4)
    private String classNumber;

    @Column(name = "name", length = 4, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "part", nullable = false)
    private Part part;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Alarm> alarms;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "my_club")
    private Club myClub;

    public void addClubMember(String name, Part part, Club clubName) {
        this.name = name;
        this.part = part;
        this.myClub = clubName;
    }

    public void addAlarm(Alarm alarm) {
        alarms.add(alarm);
    }
}
