package com.example.StudentManagementSystem.Service;

import com.example.StudentManagementSystem.Entity.Marks;
import com.example.StudentManagementSystem.Repository.MarksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private MarksRepo marksRepo;

    public List<Marks> viewOwnMarks(String studentId) {
        return marksRepo.findByStudentId(studentId);
    }
}
