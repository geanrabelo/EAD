package com.br.EAD.repository;

import com.br.EAD.entity.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentRepository extends JpaRepository<Assessment, Long> {

    boolean existsByTittle(String tittle);
}
