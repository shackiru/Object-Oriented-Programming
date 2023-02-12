package com.example.schoolsl;

public class Lecturer extends User
{
    protected int nik;
    public Lecturer()
    {

    }

    public Lecturer(String username, String password, String name, int nik)
    {
        super(username, password, name);
        this.nik = nik;
    }
}
