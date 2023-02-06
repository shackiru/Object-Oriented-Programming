package com.example.school;

import java.util.ArrayList;

public class ClassData
{
    protected String classCode;
    protected Teacher teacher;
    protected Course course;
    private ArrayList<Student> students = new ArrayList<>();
    protected ArrayList<Score> scores = new ArrayList<>();

    public ClassData()
    {

    }

    public ClassData(String classCode, Teacher teacher, Course course, ArrayList<Student> students)
    {
        this.classCode = classCode;
        this.teacher = teacher;
        this.course = course;
        this.students = new ArrayList<Student>();
    }


}
