package com.br.EAD.service;

import com.br.EAD.dto.request.course.CourseCreatedDTO;
import com.br.EAD.dto.response.course.CourseDetailsDTO;

import java.util.List;
import java.util.UUID;

public interface CourseService {

    String create(CourseCreatedDTO courseCreatedDTO);

    List<CourseDetailsDTO> findAll();

    CourseDetailsDTO findById(UUID id);

    Boolean existsById(UUID id);

    void deleteById(UUID id);
}
