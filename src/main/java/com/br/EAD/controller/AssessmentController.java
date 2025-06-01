package com.br.EAD.controller;

import com.br.EAD.dto.request.assessment.AssessmentCreatedDTO;
import com.br.EAD.dto.request.assessment.AssessmentUpdateDTO;
import com.br.EAD.dto.response.MessageDTO;
import com.br.EAD.dto.response.assessment.AssessmentDetailsDTO;
import com.br.EAD.service.AssessmentService;
import jakarta.persistence.Id;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/ead/assessment")
public class AssessmentController {

    private final AssessmentService assessmentService;

    public AssessmentController(AssessmentService assessmentService){
        this.assessmentService = assessmentService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<MessageDTO> create(@RequestBody @Validated AssessmentCreatedDTO assessmentCreatedDTO){
        return ResponseEntity.ok(new MessageDTO(assessmentService.create(assessmentCreatedDTO)));
    }

    @GetMapping
    public ResponseEntity<List<AssessmentDetailsDTO>> findAll(){
        return ResponseEntity.ok(assessmentService.findAll());
    }

    @GetMapping(path = "/id")
    public ResponseEntity<AssessmentDetailsDTO> findById(@RequestParam(name = "id") Long id){
        return ResponseEntity.ok(assessmentService.findById(id));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<AssessmentDetailsDTO> update(@RequestBody @Validated AssessmentUpdateDTO assessmentUpdateDTO){
        return ResponseEntity.ok(assessmentService.update(assessmentUpdateDTO));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<Void> delete(@RequestParam(name = "id") Long id){
        assessmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
