package com.example.StudentManagementSystem.Repository;
import com.example.StudentManagementSystem.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {
    Admin findByUsername(String username);
    boolean existsByUsername(String username);
}

