package com.example.mahasiswa;

public class Main
{
    public Main()
    {
        Mahasiswa m1 = new Mahasiswa();
        m1.setNIM("1234567890");
        System.out.println("NIM = " +  m1.getNIM());

        m1.setName("Shaquille");
        System.out.println("Name = " + m1.getName());

        m1.setGPA(3.99);
        System.out.println("GPA = " + m1.getGPA());
    }
    public static void main(String[] args)
    {
        new Main();
    }

}
