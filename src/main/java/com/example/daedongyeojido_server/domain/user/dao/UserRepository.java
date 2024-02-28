package com.example.daedongyeojido_server.domain.user.dao;

import com.example.daedongyeojido_server.domain.club.domain.Club;
import com.example.daedongyeojido_server.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByXquareId(String xquareId);
    Optional<User> findByClassNumber(String classNumber);
    List<User> findAllByMyClub(Club myClub);
    Optional<User> findByName(String name);
}
