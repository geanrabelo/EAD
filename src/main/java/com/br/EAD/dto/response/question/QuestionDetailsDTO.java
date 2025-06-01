package com.br.EAD.dto.response.question;

import com.br.EAD.entity.Question;
import com.br.EAD.enums.Type;

import java.util.List;
import java.util.UUID;

public record QuestionDetailsDTO(UUID id,
                                 String statement,
                                 List<String> options,
                                 Type type,
                                 Long assessmentId) {
    public QuestionDetailsDTO(Question question){
        this(question.getId(),
                question.getStatement(),
                question.getOptions(),
                question.getType(),
                question.getAssessment().getId()
        );
    }
}
