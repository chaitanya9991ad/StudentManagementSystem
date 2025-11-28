package com.example.StudentManagementSystem.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Marks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "studentid is required")
    private String studentId;
    @NotBlank(message = "subject is required")
    private String subject;
    @NotNull(message = "marksObtained is required")
    private Float gradeObtained;
    @NotNull(message = "totalMarks is required")
    private Float totalgrade = 10f;
}

