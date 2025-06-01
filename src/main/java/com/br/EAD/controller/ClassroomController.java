package com.br.EAD.controller;

import com.br.EAD.dto.request.classroom.ClassroomCreatedDTO;
import com.br.EAD.dto.request.classroom.ClassroomUpdateDTO;
import com.br.EAD.dto.response.MessageDTO;
import com.br.EAD.dto.response.classroom.ClassroomDetailsDTO;
import com.br.EAD.service.ClassroomService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/v1/ead/classroom")
public class ClassroomController {

    private final ClassroomService classroomService;

    public ClassroomController(ClassroomService classroomService){
        this.classroomService = classroomService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<MessageDTO> create(@RequestBody @Validated ClassroomCreatedDTO classroomCreatedDTO){
        return ResponseEntity.ok(new MessageDTO(classroomService.create(classroomCreatedDTO)));
    }

    @GetMapping
    public ResponseEntity<List<ClassroomDetailsDTO>> findAll(){
        return ResponseEntity.ok(classroomService.findAll());
    }

    @GetMapping(path = "/id")
    public ResponseEntity<ClassroomDetailsDTO> findById(@RequestParam(name = "id") String id){
        return ResponseEntity.ok(classroomService.findById(UUID.fromString(id)));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ClassroomDetailsDTO> update(@RequestBody @Validated ClassroomUpdateDTO classroomUpdateDTO){
        return ResponseEntity.ok(classroomService.update(classroomUpdateDTO));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<Void> deleteById(@RequestParam(name = "id") String id){
        classroomService.deleteById(UUID.fromString(id));
        return ResponseEntity.noContent().build();
    }
}
