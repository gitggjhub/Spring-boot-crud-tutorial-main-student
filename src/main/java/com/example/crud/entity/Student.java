package com.example.crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;

    private String studentName;

    private float studentMarks;

    public Student() {
    }

    public Student(Long studentId, String studentName, float studentMarks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentMarks = studentMarks;
    }

    public Student( String studentName, float studentMarks) {
        this.studentName = studentName;
        this.studentMarks = studentMarks;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public float getStudentMarks() {
        return studentMarks;
    }

    public void setStudentMarks(float studentMarks) {
        this.studentMarks = studentMarks;
    }


}
