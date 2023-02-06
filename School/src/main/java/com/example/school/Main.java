package com.example.school;

import java.util.ArrayList;

public class Main
{
    private ArrayList<Teacher> teachers = new ArrayList();
    private ArrayList<Student> students = new ArrayList();
    private ArrayList<Course> courses = new ArrayList();

    public Main()
    {
        //populate data teacher
        teachers.add(new Teacher("admin", "admin"));
        teachers.add(new Teacher("Killer1", "dead1"));
        teachers.add(new Teacher    ("Killer2", "dead2"));

        // populate data student

        // populate data course
            courses.add(new Course("123", "Mathematics", 4));
        //
        ArrayList<Student> studentLA01 = new ArrayList<>();
        studentLA01.add(students.get(0));
        studentLA01.add(students.get(5));
        studentLA01.add(students.get(6));

        ClassData LA01 = new ClassData("LA01", teachers.get(0), courses.get(0), studentLA01);
    }
    public static void main(String[] args)
    {
        new Main();
    }
}
