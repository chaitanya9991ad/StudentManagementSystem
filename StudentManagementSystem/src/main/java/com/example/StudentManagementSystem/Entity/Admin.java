package com.example.StudentManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @NotBlank(message = "Username is required")
    private String username;
    @NotBlank(message = "email is required")
    private String email;
    @NotBlank(message = "Password is required")
    private String password;
    @NotNull(message = "mobilenumber is required")
    private Integer mobilenumber;
    private String role;

}
