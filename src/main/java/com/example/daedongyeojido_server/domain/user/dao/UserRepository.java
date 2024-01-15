package com.example.daedongyeojido_server.domain.user.dao;

import com.example.daedongyeojido_server.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
