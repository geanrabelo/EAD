package com.br.EAD.dto.request.question;

import com.br.EAD.enums.Type;

import java.util.List;

public record QuestionCreateDTO(String statement,
                                Type type,
                                List<String> options,
                                Long assessmentId) {
}
