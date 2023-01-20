package com.example.session04;

public class Student extends Person
{
    public Student()
    {
        super("Budi", 29);

//        System.out.println("Student is created!");
//        name = "budi";
//        System.out.println("Student name: " + getName());
    }
    @Override
    public void walk()
    {
        System.out.println("Student is walking!");
    }

    // overloading
    public void walk(int n)
    {
        System.out.println("Student is walking " + n + " km");
    }
}
