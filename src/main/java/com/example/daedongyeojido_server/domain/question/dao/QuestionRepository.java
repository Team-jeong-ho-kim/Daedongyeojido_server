package com.example.daedongyeojido_server.domain.question.dao;

import com.example.daedongyeojido_server.domain.question.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
