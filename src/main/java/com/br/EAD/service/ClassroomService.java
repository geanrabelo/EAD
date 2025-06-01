package com.br.EAD.service;


import com.br.EAD.dto.request.classroom.ClassroomCreatedDTO;
import com.br.EAD.dto.request.classroom.ClassroomUpdateDTO;
import com.br.EAD.dto.response.classroom.ClassroomDetailsDTO;

import java.util.List;
import java.util.UUID;

public interface ClassroomService {

    String create(ClassroomCreatedDTO classroomCreatedDTO);

    List<ClassroomDetailsDTO> findAll();

    ClassroomDetailsDTO findById(UUID id);

    ClassroomDetailsDTO update(ClassroomUpdateDTO classroomUpdateDTO);

    Boolean existsById(UUID id);

    void deleteById(UUID id);
}
