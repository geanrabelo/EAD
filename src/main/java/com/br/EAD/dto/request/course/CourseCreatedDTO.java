package com.br.EAD.dto.request.course;

import com.br.EAD.enums.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CourseCreatedDTO(
        @NotBlank(message = "This field cannot be empty")
        String name,
        @NotBlank(message = "This field cannot be empty")
        String description,
        @NotNull(message = "This field cannot be empty")
        Category category) {

}
