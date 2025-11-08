package com.example.StudentManagementSystem.Service;

import com.example.StudentManagementSystem.Entity.Admin;
import com.example.StudentManagementSystem.Entity.Teacher;
import com.example.StudentManagementSystem.Entity.Student;
import com.example.StudentManagementSystem.Repository.AdminRepo;
import com.example.StudentManagementSystem.Repository.TeacherRepo;
import com.example.StudentManagementSystem.Repository.StudentRepo;
import com.example.StudentManagementSystem.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private TeacherRepo teacherRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    // ========================= ADMIN =========================
    public String registerAdmin(Admin admin) {
        if (adminRepo.existsByUsername(admin.getUsername())) {
            return "Admin username already exists";
        }

        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        admin.setRole("ADMIN");
        adminRepo.save(admin);
        return "Admin registered successfully";
    }

    public String adminLogin(String username, String password) {
        Admin admin = adminRepo.findByUsername(username);
        if (admin == null) {
            throw new RuntimeException("Admin not found");
        }

        if (!passwordEncoder.matches(password, admin.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtUtil.generateToken(admin.getUsername(), admin.getRole());
    }

    // ========================= TEACHER =========================
    public String registerTeacher(Teacher teacher) {
        if (teacherRepo.existsByUsername(teacher.getUsername())) {
            return "Teacher username already exists";
        }

        System.out.println("Before encoding: " + teacher.getPassword());
        teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
        teacher.setRole("TEACHER");
        System.out.println("After encoding: " + teacher.getPassword());
        teacherRepo.save(teacher);
        return "Teacher registered successfully";
    }

    public String teacherLogin(String username, String password) {
        Teacher teacher = teacherRepo.findByUsername(username);
        if (teacher == null) {
            throw new RuntimeException("Teacher not found");
        }

        if (!passwordEncoder.matches(password, teacher.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtUtil.generateToken(teacher.getUsername(), teacher.getRole());
    }

    // ========================= STUDENT =========================

    public String registerStudent(Student student) {
        if (studentRepo.existsByStudentId(student.getStudentId())) {
            return "Student ID already exists";
        }

        student.setPassword(passwordEncoder.encode(student.getPassword()));
        student.setRole("STUDENT");
        studentRepo.save(student);
        return "Student registered successfully";
    }
    public String studentLogin(String studentId, String password) {
        Student student = studentRepo.findByStudentId(studentId);
        if (student == null) {
            throw new RuntimeException("Student not found");
        }

        if (!passwordEncoder.matches(password, student.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtUtil.generateToken(student.getStudentId(), student.getRole());
    }
}
