package com.chinatelecom.rxjavastudy;

import java.util.List;

/**
 * Created by Shui on 16/10/24.
 */

public class Student {
    private String name;
    private int age;
    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
