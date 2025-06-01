package com.br.EAD.dto.request.question;

import com.br.EAD.enums.Type;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record QuestionCreateDTO(
        @NotBlank(message = "This field cannot be empty")
        String statement,
        @NotNull(message = "This field cannot be empty")
        Type type,
        @NotNull(message = "This field cannot be empty")
        List<String> options,
        @NotNull(message = "This field cannot be empty")
        Long assessmentId) {
}
