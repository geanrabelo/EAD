package com.br.EAD.dto.response.classroom;

import com.br.EAD.entity.Classroom;

import java.util.UUID;

public record ClassroomDetailsDTO(UUID id,
                                  String tittle,
                                  String description,
                                  String linkVideo,
                                  UUID courseId) {
    public ClassroomDetailsDTO(Classroom classroom){
        this(classroom.getId(), classroom.getTittle(), classroom.getDescription(), classroom.getLinkVideo(), classroom.getCourse().getId());
    }
}
