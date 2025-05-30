package com.br.EAD.dto.request.course;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record CourseUpdateDTO(
        @NotBlank(message = "This field cannot be empty")
        UUID id,
        @NotBlank(message = "This field cannot be empty")
        String name,
        @NotBlank(message = "This field cannot be empty")
        String description,
        @NotBlank(message = "This field cannot be empty")
        Boolean active) {
}
