package com.example.educare.Model;

public  class Student {

    private String StudentName;
    public Student(String coursename){
        StudentName=coursename;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }
}

