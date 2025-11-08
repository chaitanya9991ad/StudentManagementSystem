package com.example.StudentManagementSystem.Repository;

import com.example.StudentManagementSystem.Entity.Marks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarksRepo extends JpaRepository<Marks, Integer> {
    List<Marks> findByStudentId(String studentId);
    Optional<Marks> findByStudentIdAndSubject(String studentId, String subject);
}
