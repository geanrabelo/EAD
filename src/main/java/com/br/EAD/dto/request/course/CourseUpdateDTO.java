package com.br.EAD.dto.request.course;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CourseUpdateDTO(
        @NotNull(message = "This field cannot be empty")
        UUID id,
        @NotBlank(message = "This field cannot be empty")
        String name,
        @NotBlank(message = "This field cannot be empty")
        String description,
        Boolean active) {
}
