package com.example.crud.controller;

import com.example.crud.entity.Student;
import com.example.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class StudentController {

    @Autowired
    private StudentService studentServiceObject;

    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student) {
        System.out.println("Here is your student details: ");
        return studentServiceObject.saveStudent(student);
    }

    @GetMapping("/student")
    public List<Student> getAllStudents() {
        System.out.println("Get all employee details- Controller");
        return studentServiceObject.fetchAllStudents();
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable("id") Long id) {
        return studentServiceObject.getStudentById(id);
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        return studentServiceObject.updateStudentById(id, student);
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        return studentServiceObject.deleteStudentById(id);
    }
    @GetMapping("/studentMarks")
    public List<Student> getMarkStudents(){
        return studentServiceObject.getStudentMarks();
    } 
    
    
}
