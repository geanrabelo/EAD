package com.br.EAD.dto.request.question;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record QuestionUpdateDTO(
        @NotBlank(message = "This field cannot be empty")
        String statement,
        @NotBlank(message = "This field cannot be empty")
        List<String> options) {
}
