package com.br.EAD.dto.response.question;

import com.br.EAD.entity.Question;
import com.br.EAD.enums.Type;

import java.util.UUID;

public record QuestionDetailsDTO(UUID id,
                                 String statement,
                                 Type type,
                                 Long assessmentId) {
    public QuestionDetailsDTO(Question question){
        this(question.getId(),
                question.getStatement(),
                question.getType(),
                question.getAssessment().getId()
        );
    }
}
