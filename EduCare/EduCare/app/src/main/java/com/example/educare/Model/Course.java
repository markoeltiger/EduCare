package com.example.educare.Model;

public class Course {
    private String name , Subject, code,coursedescripton,courseperiod;
    public Course() {
    }


    public Course(String name, String subject, String code, String coursedescripton, String courseperiod){
        name=name;
        Subject = subject;
        code = code;
        coursedescripton = coursedescripton;
        courseperiod = courseperiod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        code = code;
    }

    public String getCoursedescripton() {
        return coursedescripton;
    }

    public void setCoursedescripton(String coursedescripton) {
        this.coursedescripton = coursedescripton;
    }

    public String getCourseperiod() {
        return courseperiod;
    }

    public void setCourseperiod(String courseperiod) {
        this.courseperiod = courseperiod;
    }
}
