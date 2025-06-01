package com.br.EAD.dto.response.assessment;

import com.br.EAD.entity.Assessment;
import com.br.EAD.enums.Type;

import java.time.LocalDateTime;
import java.util.UUID;

public record AssessmentDetailsDTO(Long id,
                                   String tittle,
                                   Type type,
                                   UUID courseId,
                                   LocalDateTime createdAt) {
    public AssessmentDetailsDTO(Assessment assessment){
        this(assessment.getId(),
                assessment.getTittle(),
                assessment.getType(),
                assessment.getCourse().getId(),
                assessment.getCreatedAt()
        );
    }
}
