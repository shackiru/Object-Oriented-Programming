package com.example.schoolsl;

import java.util.ArrayList;

public class ClassData
{
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Score> scores = new ArrayList<>();
    protected Lecturer lecturer;
    protected Subject subject;
    protected String className;
    protected String classCode;

    public Lecturer getLecturer()
    {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer)
    {
        this.lecturer = lecturer;
    }

    public Subject getSubject()
    {
        return subject;
    }

    public void setSubject(Subject subject)
    {
        this.subject = subject;
    }

    public String getClassName()
    {
        return className;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }

    public String getClassCode()
    {
        return classCode;
    }

    public void setClassCode(String classCode)
    {
        this.classCode = classCode;
    }
}
