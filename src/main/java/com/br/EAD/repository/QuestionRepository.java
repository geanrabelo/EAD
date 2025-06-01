package com.br.EAD.repository;

import com.br.EAD.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuestionRepository extends JpaRepository<Question, UUID> {

    boolean existsByStatement(String statement);
}
