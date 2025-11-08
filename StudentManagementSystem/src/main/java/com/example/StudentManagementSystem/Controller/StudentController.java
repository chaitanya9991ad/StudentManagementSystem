package com.example.StudentManagementSystem.Controller;

import com.example.StudentManagementSystem.Entity.Marks;
import com.example.StudentManagementSystem.Service.StudentService;
import com.example.StudentManagementSystem.security.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "*")
@PreAuthorize("hasRole('STUDENT')")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private JwtUtil jwtUtil;

    // View own marks (authenticated student only)
    @GetMapping("/viewGrades")
    public List<Marks> viewMarks(HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        String studentId = jwtUtil.extractUsername(token);
        return studentService.viewOwnMarks(studentId);
    }
}
