package cz.vsb.magistri.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "student")
@Getter
@Setter
public class StudentEntity {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
    //@Column(length = 255) defaulne
    String firstName;
    String lastName;
    LocalDate dateOfBirth;
}
