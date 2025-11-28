package com.example.StudentManagementSystem.Repository;

import com.example.StudentManagementSystem.Entity.Student;
import com.example.StudentManagementSystem.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Integer> {
    Teacher findByUsername(String username);
    boolean existsByUsername(String username);
}
