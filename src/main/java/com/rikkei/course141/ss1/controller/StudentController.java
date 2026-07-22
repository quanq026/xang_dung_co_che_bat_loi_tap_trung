package com.rikkei.course141.ss1.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.rikkei.course141.ss1.exception.StudentNotFoundException;
import com.rikkei.course141.ss1.model.Student;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final List<Student> students = List.of(
        new Student(1L, "Nguyen Van A", "a@rikkei.edu"),
        new Student(2L, "Tran Thi B", "b@rikkei.edu"),
        new Student(3L, "Le Van C", "c@rikkei.edu")
    );

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return students.stream()
            .filter(s -> s.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new StudentNotFoundException("Sinh viên không tồn tại"));
    }
}
