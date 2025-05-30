package com.br.EAD.dto.response.course;

import com.br.EAD.entity.Course;
import com.br.EAD.enums.Category;

import java.time.LocalDateTime;
import java.util.UUID;

public record CourseDetailsDTO(UUID id,
                               String name,
                               String description,
                               Category category,
                               LocalDateTime createdAt,
                               Boolean active) {

    public CourseDetailsDTO(Course course){
        this(course.getId(),
                course.getName(),
                course.getDescription(),
                course.getCategory(),
                course.getCreatedAt(),
                course.getActive());
    }
}
