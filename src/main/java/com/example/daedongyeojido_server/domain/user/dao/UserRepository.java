package com.example.daedongyeojido_server.domain.user.dao;

import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByAccountId(String accountId);

    Optional<User> findByClassNumber(String classNumber);

    List<User> findAllByMyClub(Club myClub);

    Optional<User> findByName(String name);

    Boolean existsByUserId(String userId);
}