package com.example.daedongyeojido_server.domain.notice.domain;

import com.example.daedongyeojido_server.domain.notice.domain.enums.Major;
import com.example.daedongyeojido_server.domain.notice.dto.request.FieldRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "field_id", nullable = false)
    private Long fieldId;

    @Column(name = "major", nullable = false)
    private Major major;

    @Column(name = "to_do", nullable = false)
    private String toDo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice", nullable = false)
    private Notice notice;

    public Field(FieldRequest request) {
        this.major = request.getMajor();
        this.toDo = request.getToDo();
    }
}
