package cz.vsb.magistri.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data() //https://projectlombok.org/features/
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDto {
    Integer id;
    String name;
}