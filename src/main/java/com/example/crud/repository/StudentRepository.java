package com.example.crud.repository;

import com.example.crud.entity.Student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "SELECT * FROM student WHERE student_marks >?1", nativeQuery = true)
    List<Student> findStudentsByMarks(float student_marks);
}
// change
// change2