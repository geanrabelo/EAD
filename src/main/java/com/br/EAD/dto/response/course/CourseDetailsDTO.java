package com.br.EAD.dto.response.course;

import com.br.EAD.enums.Category;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.UUID;

public record CourseDetailsDTO(UUID id,
                               String name,
                               String description,
                               Category category,
                               LocalDateTime createdAt,
                               Boolean active) {
}
