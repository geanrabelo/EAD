package com.br.EAD.service.impl;

import com.br.EAD.dto.request.classroom.ClassroomCreatedDTO;
import com.br.EAD.dto.request.classroom.ClassroomUpdateDTO;
import com.br.EAD.dto.response.classroom.ClassroomDetailsDTO;
import com.br.EAD.entity.Classroom;
import com.br.EAD.entity.Course;
import com.br.EAD.enums.EnumCode;
import com.br.EAD.exceptions.ex.ClassroomNotFound;
import com.br.EAD.exceptions.ex.ClassroomTittleAlreadyExists;
import com.br.EAD.exceptions.ex.CourseNotFound;
import com.br.EAD.repository.ClassroomRepository;
import com.br.EAD.repository.CourseRepository;
import com.br.EAD.service.ClassroomService;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    private final ClassroomRepository classroomRepository;
    private final CourseRepository courseRepository;

    public ClassroomServiceImpl(ClassroomRepository classroomRepository, CourseRepository courseRepository){
        this.classroomRepository = classroomRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public String create(ClassroomCreatedDTO classroomCreatedDTO) {
        if(classroomRepository.existsByTittle(classroomCreatedDTO.tittle())){
            throw new ClassroomTittleAlreadyExists(EnumCode.CLR000.getMessage());
        }
        if(!courseRepository.existsById(classroomCreatedDTO.courseId())){
            throw new CourseNotFound(EnumCode.CRS001.getMessage());
        }
        Course courseDatabase = courseRepository.getReferenceById(classroomCreatedDTO.courseId());
        Classroom classroom = Classroom
                .builder()
                .tittle(classroomCreatedDTO.tittle())
                .description(classroomCreatedDTO.description())
                .linkVideo(classroomCreatedDTO.linkVideo())
                .course(courseDatabase)
                .build();
        classroomRepository.save(classroom);
        return "Classroom registered successfully";
    }

    @Override
    public List<ClassroomDetailsDTO> findAll() {
        return classroomRepository.findAll().stream().map(ClassroomDetailsDTO::new).toList();
    }

    @Override
    public ClassroomDetailsDTO findById(UUID id) {
        if(!classroomRepository.existsById(id)) throw new ClassroomNotFound(EnumCode.CLR001.getMessage());
        return new ClassroomDetailsDTO(classroomRepository.getReferenceById(id));
    }

    @Override
    public ClassroomDetailsDTO update(ClassroomUpdateDTO classroomUpdateDTO) {
        if(!classroomRepository.existsById(classroomUpdateDTO.id())) throw new ClassroomNotFound(EnumCode.CLR001.getMessage());
        Classroom classroomDatabase = classroomRepository.getReferenceById(classroomUpdateDTO.id());
        classroomDatabase.setTittle(classroomUpdateDTO.tittle());
        classroomDatabase.setDescription(classroomDatabase.getDescription());
        classroomDatabase.setLinkVideo(classroomDatabase.getLinkVideo());
        Classroom classroomDatabaseUpdated = classroomRepository.save(classroomDatabase);
        return new ClassroomDetailsDTO(classroomDatabaseUpdated);
    }

    @Override
    public Boolean existsById(UUID id) {
        return classroomRepository.existsById(id);
    }

    @Override
    public void deleteById(UUID id) {
        if(!classroomRepository.existsById(id)) throw new ClassroomNotFound(EnumCode.CLR001.getMessage());
        classroomRepository.deleteById(id);
    }
}
