package com.example.daedongyeojido_server.domain.user.dao;

import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.user.domain.User;
import com.example.daedongyeojido_server.domain.user.domain.enums.Part;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.example.daedongyeojido_server.domain.user.domain.QUser.user;

@Repository
@RequiredArgsConstructor
public class CustomUserRepositoryImpl implements CustomUserRepository {

    private final JPAQueryFactory queryFactory;

    public Optional<User> findTeacherByName(String name) {
        User teacher = queryFactory
                .selectFrom(user)
                .where(user.part.eq(Part.TEACHER)
                        .or(user.part.eq(Part.CLUB_LEADER_TEACHER)))
                .where(user.name.eq(name))
                .fetchOne();

        return Optional.ofNullable(teacher);
    }

    public User findLeaderByClub(Club club) {
        return queryFactory
                .selectFrom(user)
                .where(user.myClub.eq(club).and(user.part.eq(Part.CLUB_LEADER)))
                .fetchOne();
    }
}