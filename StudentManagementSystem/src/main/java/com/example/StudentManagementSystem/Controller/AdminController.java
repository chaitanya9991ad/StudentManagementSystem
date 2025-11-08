package com.example.StudentManagementSystem.Controller;

import com.example.StudentManagementSystem.Entity.Marks;
import com.example.StudentManagementSystem.Entity.Student;
import com.example.StudentManagementSystem.Entity.Teacher;
import com.example.StudentManagementSystem.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Add Teacher
    @PostMapping("/addTeacher")
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return adminService.addTeacher(teacher);
    }
    @PutMapping("/updateTeacher")
    public Teacher updateTeacher(@RequestBody Teacher teacher) {
        return adminService.updateTeacher(teacher);
    }
    // Delete Teacher by ID
    @DeleteMapping("/deleteTeacher/{id}")
    public String deleteTeacher(@PathVariable int id) {
        adminService.deleteTeacher(id);
        return "Teacher deleted successfully.";
    }

    // View all Teachers
    @GetMapping("/teachers")
    public List<Teacher> viewTeachers() {
        return adminService.viewAllTeachers();
    }

    // View all Students' Grades
    @GetMapping("/viewStudentGrades")
    public List<Marks> viewStudentGrades() {
        return adminService.viewAllStudentGrades();
    }
}
