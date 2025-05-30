package com.br.EAD.dto.request.course;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record CourseUpdateDTO(
        @NotBlank(message = "This field cannot be empty")
        UUID id,
        String name,
        String description,
        Boolean active) {
}
