package com.br.EAD.service;

import com.br.EAD.dto.request.assessment.AssessmentCreatedDTO;
import com.br.EAD.dto.request.assessment.AssessmentUpdateDTO;
import com.br.EAD.dto.response.assessment.AssessmentDetailsDTO;

import java.util.List;
import java.util.UUID;

public interface AssessmentService {

    String create(AssessmentCreatedDTO assessmentCreatedDTO);

    List<AssessmentDetailsDTO> findAll();

    AssessmentDetailsDTO findById(Long id);

    AssessmentDetailsDTO update(AssessmentUpdateDTO assessmentUpdateDTO);

    Boolean existsById(Long id);

    void deleteById(Long id);
}
