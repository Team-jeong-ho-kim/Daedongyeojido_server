package com.example.daedongyeojido_server.domain.user.dao;

import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.user.domain.User;

public interface CustomUserRepository {
    User findLeaderByClub(Club club);
}