package com.example.StudentManagementSystem.Controller;

import com.example.StudentManagementSystem.Entity.Marks;
import com.example.StudentManagementSystem.Entity.Student;
import com.example.StudentManagementSystem.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/teacher")
@CrossOrigin(origins = "*")
@PreAuthorize("hasRole('TEACHER')")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    // Register a new Student
    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student) {
        return teacherService.addStudent(student);
    }

    // Update existing Student
    @PutMapping("/updateStudent")
    public Student updateStudent(@RequestBody Student student) {
        return teacherService.updateStudent(student);
    }

    // Delete Student
    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id) {
        teacherService.deleteStudent(id);
        return "Student deleted successfully.";
    }

    // Assign Grades to student
    @PostMapping("/assignGrades")
    public Marks assignGrades(@RequestBody Marks marks) {
        return teacherService.assignGrades(marks);
    }
    // Assign Grades to student
    @PutMapping("/upgradeGrades")
    public Marks upgradeGrades(@RequestBody Marks marks) {
        return teacherService.upgradeGrades(marks);
    }

    // View all students
    @GetMapping("/viewAllStudents")
    public List<Student> viewAllStudents() {
        return teacherService.viewAllStudents();
    }
}
