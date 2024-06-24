package cz.vsb.magistri.service;

import cz.vsb.magistri.dto.GradeDto;
import cz.vsb.magistri.entity.GradeEntity;
import cz.vsb.magistri.mapper.GradeMapper;
import cz.vsb.magistri.repository.GradeRepository;
import cz.vsb.magistri.repository.StudentRepository;
import cz.vsb.magistri.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GradeService {
    @Autowired
    GradeRepository gradeRepository;
    @Autowired
    GradeMapper gradeMapper;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    StudentRepository studentRepository;

    public GradeDto addGrade(GradeDto gradeDto){
        GradeEntity gradeToAdd = gradeMapper.toEntity(gradeDto);
        gradeToAdd.setSubject(subjectRepository.getReferenceById(gradeDto.getSubjectId()));
        gradeToAdd.setStudent(studentRepository.getReferenceById(gradeDto.getStudentId()));
        return gradeMapper.toDto(gradeRepository.save(gradeToAdd));
    }

    public List<GradeDto> getAllGrades() {
        List<GradeDto> allGrades = new ArrayList<>();
        for (GradeEntity gradeEntity : gradeRepository.findAll()) {
//            GradeDto gradeDto = gradeMapper.toDto(GradeEntity);
//            gradeDto.setStudentDto(studentRepository.getReferenceById(gradeEntity.));
            allGrades.add(gradeMapper.toDto(gradeEntity));

        }
        return allGrades;
    }

    public  GradeDto getGradeById(int gradeId){
        return gradeMapper.toDto(gradeRepository.getReferenceById(gradeId));
    }

    public GradeDto editGrade(int gradeId, GradeDto gradeDto){
        gradeDto.setId(gradeId);
        GradeEntity gradeEntity = gradeRepository.getReferenceById(gradeId);
        gradeMapper.updateEntity(gradeDto, gradeEntity);
        gradeEntity.setSubject(subjectRepository.getReferenceById(gradeDto.getSubjectId()));
        gradeEntity.setStudent(studentRepository.getReferenceById(gradeDto.getStudentId()));
        return gradeMapper.toDto(gradeRepository.save(gradeEntity));
    }

    public GradeDto deleteGrade(int gradeId){
        GradeEntity gradeToDel = gradeRepository.getReferenceById(gradeId);
        GradeDto deletedGrade = gradeMapper.toDto(gradeToDel);
        gradeRepository.delete(gradeToDel);
        return deletedGrade;
    }
}
