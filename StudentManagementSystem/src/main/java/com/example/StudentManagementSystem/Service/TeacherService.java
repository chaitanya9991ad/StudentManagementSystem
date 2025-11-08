package com.example.StudentManagementSystem.Service;

import com.example.StudentManagementSystem.Entity.Marks;
import com.example.StudentManagementSystem.Entity.Student;
import com.example.StudentManagementSystem.Repository.MarksRepo;
import com.example.StudentManagementSystem.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private MarksRepo marksRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addStudent(Student student) {
        if (studentRepo.existsByStudentId(student.getStudentId())) {
            return "Student ID already exists";
        }

        student.setPassword(passwordEncoder.encode(student.getPassword()));
        student.setRole("STUDENT");
        studentRepo.save(student);
        return "Student registered successfully";
    }

    public Student updateStudent(Student student) {
        return studentRepo.save(student);
    }

    public void deleteStudent(int id) {
        studentRepo.deleteById(id);
    }

    public Marks assignGrades(Marks marks) {
        return marksRepo.save(marks);
    }

    public Marks upgradeGrades(Marks updatedMarks) {
        // 1. Find the existing grade record using studentId and subject
        Marks existingMark = marksRepo
                .findByStudentIdAndSubject(updatedMarks.getStudentId(), updatedMarks.getSubject())
                .orElseThrow(() -> new RuntimeException("No grade found to update for student " + updatedMarks.getStudentId() + " in " + updatedMarks.getSubject()));

        // 2. Update the fields of the *existing* record
        existingMark.setGradeObtained(updatedMarks.getGradeObtained());
        existingMark.setTotalgrade(updatedMarks.getTotalgrade());

        // 3. Save the *existing* record (which has the correct ID)
        return marksRepo.save(existingMark);
    }

    public List<Student> viewAllStudents() {
        return studentRepo.findAll();
    }
}
