package com.example.mahasiswa;

public class Mahasiswa
{
    private String NIM;
    private String name;
    private double GPA;



    public Mahasiswa()
    {
        System.out.println("Mahasiswa dibuat");
    }

    public Mahasiswa(String NIM, String name, double GPA)
    {
        this.NIM = NIM;
        this.name = name;
        this.GPA = GPA;
    }
    public String getNIM()
    {
        return NIM;
    }

    public void setNIM(String NIM)
    {
        this.NIM = NIM;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public double getGPA()
    {
        return GPA;
    }

    public void setGPA(double GPA)
    {
        this.GPA = GPA;
    }

    public void print()
    {
        System.out.println("NIM: " + NIM);
        System.out.println("Name : " + name);
        System.out.println("GPA: " + GPA);
    }
}
