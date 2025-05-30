package com.br.EAD.controller;

import com.br.EAD.dto.request.course.CourseCreatedDTO;
import com.br.EAD.dto.request.course.CourseUpdateDTO;
import com.br.EAD.dto.response.MessageDTO;
import com.br.EAD.dto.response.course.CourseDetailsDTO;
import com.br.EAD.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/v1/ead/course")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<MessageDTO> create(@RequestBody @Validated CourseCreatedDTO courseCreatedDTO){
        return ResponseEntity.ok(new MessageDTO(courseService.create(courseCreatedDTO)));
    }

    @GetMapping
    public ResponseEntity<List<CourseDetailsDTO>> findAll(){
        return ResponseEntity.ok(courseService.findAll());
    }

    @GetMapping(path = "/id")
    public ResponseEntity<CourseDetailsDTO> findById(@RequestParam(name = "id") String id){
        return ResponseEntity.ok(courseService.findById(UUID.fromString(id)));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<CourseDetailsDTO> update(@RequestBody @Validated CourseUpdateDTO courseUpdateDTO){
        return ResponseEntity.ok(courseService.update(courseUpdateDTO));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<Void> delete(@RequestParam(name = "id") String id){
        courseService.deleteById(UUID.fromString(id));
        return ResponseEntity.noContent().build();
    }
}
