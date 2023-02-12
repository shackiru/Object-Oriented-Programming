package com.example.schoolsl;

public class Student extends User
{
    protected int nim;

    public Student()
    {

    }
    public Student(String username, String password, String name, int nim) {
        super(username, password, name);
        this.nim = nim;
    }
    public int getNim()
    {
        return nim;
    }
}
