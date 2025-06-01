package com.br.EAD.service.impl;

import com.br.EAD.dto.request.assessment.AssessmentCreatedDTO;
import com.br.EAD.dto.request.assessment.AssessmentUpdateDTO;
import com.br.EAD.dto.response.assessment.AssessmentDetailsDTO;
import com.br.EAD.entity.Assessment;
import com.br.EAD.entity.Course;
import com.br.EAD.enums.EnumCode;
import com.br.EAD.exceptions.ex.AssessmentNotFound;
import com.br.EAD.exceptions.ex.AssessmentTittleAlreadyExists;
import com.br.EAD.exceptions.ex.CourseNotFound;
import com.br.EAD.repository.AssessmentRepository;
import com.br.EAD.repository.CourseRepository;
import com.br.EAD.service.AssessmentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class AssessmentServiceImpl implements AssessmentService {

    private final AssessmentRepository assessmentRepository;
    private final CourseRepository courseRepository;

    public AssessmentServiceImpl(AssessmentRepository assessmentRepository, CourseRepository courseRepository){
        this.assessmentRepository = assessmentRepository;
        this.courseRepository = courseRepository;
    }


    @Override
    public String create(AssessmentCreatedDTO assessmentCreatedDTO) {
        if(assessmentRepository.existsByTittle(assessmentCreatedDTO.tittle())) throw new AssessmentTittleAlreadyExists(EnumCode.ASS000.getMessage());
        if(!courseRepository.existsById(assessmentCreatedDTO.courseId())) throw new CourseNotFound(EnumCode.CRS001.getMessage());
        Course courseDatabase = courseRepository.getReferenceById(assessmentCreatedDTO.courseId());
        Assessment assessment = Assessment
                .builder()
                .tittle(assessmentCreatedDTO.tittle())
                .type(assessmentCreatedDTO.type())
                .course(courseDatabase)
                .createdAt(LocalDateTime.now())
                .build();
        assessmentRepository.save(assessment);
        return "Assessment registered successfully";
    }

    @Override
    public List<AssessmentDetailsDTO> findAll() {
        return assessmentRepository.findAll().stream().map(AssessmentDetailsDTO::new).toList();
    }

    @Override
    public AssessmentDetailsDTO findById(Long id) {
        if(!existsById(id)) throw new AssessmentNotFound(EnumCode.ASS001.getMessage());
        return new AssessmentDetailsDTO(assessmentRepository.getReferenceById(id));
    }

    @Override
    public AssessmentDetailsDTO update(AssessmentUpdateDTO assessmentUpdateDTO) {
        if(!existsById(assessmentUpdateDTO.id())) throw new AssessmentNotFound(EnumCode.ASS001.getMessage());
        Assessment assessmentDatabase = assessmentRepository.getReferenceById(assessmentUpdateDTO.id());
        assessmentDatabase.setTittle(assessmentDatabase.getTittle());
        assessmentDatabase.setType(assessmentDatabase.getType());
        Assessment assessmentDatabaseUpdated = assessmentRepository.save(assessmentDatabase);
        return new AssessmentDetailsDTO(assessmentDatabaseUpdated);
    }

    @Override
    public Boolean existsById(Long id) {
        return assessmentRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        if(!existsById(id)) throw new AssessmentNotFound(EnumCode.ASS001.getMessage());
        assessmentRepository.deleteById(id);
    }
}
