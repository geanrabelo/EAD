package com.br.EAD.dto.request.course;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CourseUpdateDTO(
        @NotNull(message = "This field cannot be empty")
        UUID id,
        String name,
        String description,
        Boolean active) {
}
