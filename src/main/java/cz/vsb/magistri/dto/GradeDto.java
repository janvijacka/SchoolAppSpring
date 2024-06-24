package cz.vsb.magistri.dto;

import cz.vsb.magistri.entity.StudentEntity;
import cz.vsb.magistri.entity.SubjectEntity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GradeDto {
    private Integer Id;
    private StudentDto student;
    private SubjectDto subject;
    private Integer studentId;
    private Integer subjectId;
    private String topic;
    private int mark;
}
