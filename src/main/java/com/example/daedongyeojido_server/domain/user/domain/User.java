package com.example.daedongyeojido_server.domain.user.domain;

import com.example.daedongyeojido_server.domain.user.domain.type.Part;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    private UUID userId;

    @Column(name = "class_number", length = 4, nullable = false)
    private String classNumber;

    @Column(name = "name", length = 4, nullable = false)
    private String name;

    @Column(name = "account_id", length = 20, nullable = false)
    private String accountId;

    @Column(name = "password", length = 20)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "part", nullable = false)
    private Part part;

//    @Column(name = "alarms")
//    private List<Alarm> alarms;

    @Column
    private String myClub;

}
