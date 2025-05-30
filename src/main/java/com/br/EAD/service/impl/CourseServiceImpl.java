package com.br.EAD.service.impl;

import com.br.EAD.dto.request.course.CourseCreatedDTO;
import com.br.EAD.dto.request.course.CourseUpdateDTO;
import com.br.EAD.dto.response.course.CourseDetailsDTO;
import com.br.EAD.entity.Course;
import com.br.EAD.enums.EnumCode;
import com.br.EAD.exceptions.ex.CourseNotFound;
import com.br.EAD.exceptions.ex.CourseTittleAlreadyExists;
import com.br.EAD.repository.CourseRepository;
import com.br.EAD.service.CourseService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public String create(CourseCreatedDTO courseCreatedDTO) {
        if(courseRepository.existsByName(courseCreatedDTO.name())){
            throw new CourseTittleAlreadyExists(EnumCode.CRS000.getMessage());
        }
        Course course = Course
                .builder()
                .name(courseCreatedDTO.name())
                .description(courseCreatedDTO.description())
                .category(courseCreatedDTO.category())
                .createdAt(LocalDateTime.now())
                .active(true)
                .build();
        courseRepository.save(course);
        return "Course registered successfully";
    }

    @Override
    public List<CourseDetailsDTO> findAll() {
        return courseRepository.findAll().stream().map(CourseDetailsDTO::new).toList();
    }

    @Override
    public CourseDetailsDTO findById(UUID id) {
        if(!courseRepository.existsById(id)) throw new CourseNotFound(EnumCode.CRS001.getMessage());
        return new CourseDetailsDTO(courseRepository.getReferenceById(id));
    }

    @Override
    public CourseDetailsDTO update(CourseUpdateDTO courseUpdateDTO) {
        if(!courseRepository.existsById(courseUpdateDTO.id())) throw new CourseNotFound(EnumCode.CRS001.getMessage());
        Course courseDatabase = courseRepository.getReferenceById(courseUpdateDTO.id());
        if(courseUpdateDTO.name() != null){
            courseDatabase.setName(courseUpdateDTO.name());
        }
        if(courseUpdateDTO.description() != null){
            courseDatabase.setDescription(courseUpdateDTO.description());
        }
        if(courseUpdateDTO.active() != null){
            courseDatabase.setActive(courseUpdateDTO.active());
        }
        Course courseSaved = courseRepository.save(courseDatabase);
        return new CourseDetailsDTO(courseSaved);
    }

    @Override
    public Boolean existsById(UUID id) {
        return courseRepository.existsById(id);
    }

    @Override
    public void deleteById(UUID id) {
        if(!courseRepository.existsById(id)) throw new CourseNotFound(EnumCode.CRS001.getMessage());
        courseRepository.deleteById(id);
    }
}
