package com.example.daedongyeojido_server.domain.user.dao;

import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.user.domain.User;

import java.util.Optional;

public interface CustomUserRepository {
    Optional<User> findTeacherByName(String name);
    User findLeaderByClub(Club club);
}
