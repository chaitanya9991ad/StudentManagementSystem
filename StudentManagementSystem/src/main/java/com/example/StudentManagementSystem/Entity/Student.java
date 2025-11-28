package com.example.StudentManagementSystem.Entity;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "studentid is required")
    private String studentId;
    @NotBlank(message = "name is required")
    private String name;
    @NotBlank(message = "branch is required")
    private String branch;
    @NotBlank(message = "Password is required")
    private String password;
    @NotBlank(message = "year is required")
    private int year;
    private String role = "STUDENT";
}

