package com.example.crud.service;

import com.example.crud.entity.Student;
import com.example.crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService{

    @Autowired
    private StudentRepository studentRepository;

    
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    
    public List<Student> fetchAllStudents() {
        System.out.println("You are in service layer- calling fetchAllStudents");
        List<Student> allStudents = studentRepository.findAll();
        System.out.println("Listing all students:"+allStudents);
        return allStudents;
    }

    
    public Student getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        }
        return null;
    }

    
    public Student updateStudentById(Long id, Student student) {
        Optional<Student> student1 = studentRepository.findById(id);

        if (student1.isPresent()) {
            Student originalStudent = student1.get();

            if (Objects.nonNull(student.getStudentName()) && !"".equalsIgnoreCase(student.getStudentName())) {
                originalStudent.setStudentName(student.getStudentName());
            }
            if (Objects.nonNull(student.getStudentMarks()) && student.getStudentMarks() != 0) {
                originalStudent.setStudentMarks(student.getStudentMarks());
            }
            return studentRepository.save(originalStudent);
        }
        return null;
    }

    
    public String deleteStudentById(Long id) {
        if (studentRepository.findById(id).isPresent()) {
            studentRepository.deleteById(id);
            return "Student deleted successfully";
        }
        return "No such student in the database";
    }
    
    public List<Student> getStudentMarks(){
        List<Student> allStudents = studentRepository.findAll();
        List<Student> conditionMarks = new ArrayList<Student>();
        for(int i=0; i<allStudents.size(); i++){
            Student student = allStudents.get(i);
            float studentMarks = student.getStudentMarks();
            if(studentMarks>50.0){
                conditionMarks.add(student);
            }
        }
        return conditionMarks;
        // List<Student> allStudents = studentRepository.findStudentsByMarks(90);
        // return allStudents;
    }
}
