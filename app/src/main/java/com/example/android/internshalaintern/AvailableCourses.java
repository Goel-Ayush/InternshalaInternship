package com.example.android.internshalaintern;

public class AvailableCourses {
    String CourseName;
    String AboutCourse;

    public AvailableCourses(String name, String about){
        CourseName = name;
        AboutCourse = about;

    }
    public String getAboutCourse() {
        return AboutCourse;
    }

    public String getCourseName() {
        return CourseName;
    }
}
