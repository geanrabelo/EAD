package com.br.EAD.repository;

import com.br.EAD.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClassroomRepository extends JpaRepository<Classroom, UUID> {
}
