package com.example.StudentManagementSystem.Service;

import com.example.StudentManagementSystem.Entity.Marks;
import com.example.StudentManagementSystem.Entity.Teacher;
import com.example.StudentManagementSystem.Repository.MarksRepo;
import com.example.StudentManagementSystem.Repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private TeacherRepo teacherRepo;

    @Autowired
    private MarksRepo marksRepo;

    public Teacher addTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);
    }
    public Teacher updateTeacher(Teacher teacher) {
        if (!teacherRepo.existsById(teacher.getId())) {
            throw new RuntimeException("Teacher not found with ID: " + teacher.getId());
        }
        return teacherRepo.save(teacher);
    }

    public void deleteTeacher(int id) {
        if (!teacherRepo.existsById(id)) {
            throw new RuntimeException("Teacher not found with ID: " + id);
        }
        teacherRepo.deleteById(id);
    }

    public List<Teacher> viewAllTeachers() {
        return teacherRepo.findAll();
    }

    public List<Marks> viewAllStudentGrades() {
        return marksRepo.findAll();
    }
}
