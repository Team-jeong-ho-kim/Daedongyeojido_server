//package com.example.daedongyeojido_server.domain.alarm.domain;
//
//import com.example.daedongyeojido_server.domain.alarm.domain.type.PassOrNot;
//import jakarta.persistence.*;
//import lombok.AccessLevel;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//@Getter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@Entity
//public class Alarm {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "title", length = 20, nullable = false)
//    private String title;
//
//    @Column(name = "contents", length = 200)
//    private String contents;
//
//    @Column(name = "pass_or_not")
//    @Enumerated(EnumType.STRING)
//    private PassOrNot passOrNot;
//
//    @Column(name = "club_name", length = 20)
//    private String clubName;
//
//    @Column(name = "user_name", length = 4)
//    private String userName;
//
//    public void interviewStatus() {
//        this.messAgree = true;
//    }
//}