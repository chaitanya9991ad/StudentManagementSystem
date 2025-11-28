package com.example.StudentManagementSystem.Controller;

import com.example.StudentManagementSystem.Entity.Admin;
import com.example.StudentManagementSystem.Entity.Student;
import com.example.StudentManagementSystem.Entity.Teacher;
import com.example.StudentManagementSystem.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    // ADMIN Register/Login
    @PostMapping("/admin/register")
    public String registerAdmin(@RequestBody Admin admin) {
        return authService.registerAdmin(admin);
    }

    @PostMapping("/admin/login")
    public String adminLogin(@RequestBody Map<String, String> request) {
        return authService.adminLogin(request.get("username"), request.get("password"));
    }

    // TEACHER Register/Login — Only ADMIN can register teacher
    @PostMapping("/teacher/register")
    @PreAuthorize("hasRole('ADMIN')")
    public String registerTeacher(@RequestBody Teacher teacher) {
        return authService.registerTeacher(teacher);
    }

    @PostMapping("/teacher/login")
    public String teacherLogin(@RequestBody Map<String, String> request) {
        return authService.teacherLogin(request.get("username"), request.get("password"));
    }

    // STUDENT Register/Login — Teachers register students, not via auth
    @PostMapping("/student/login")
    public String studentLogin(@RequestBody Map<String, String> request) {
        return authService.studentLogin(request.get("studentId"), request.get("password"));
    }
}
