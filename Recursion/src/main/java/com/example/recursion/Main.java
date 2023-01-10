package com.example.recursion;

public class Main
{
    public static void main(String[] args)
    {
        Pen p = new Pen();
        System.out.println(p.color);
        System.out.println(p.type);
        System.out.println(p.point);
        p.click();
        System.out.println(p.clicked);
    }
    public static void sayHi(int n)
    {
        if(n == 0)
        {
            System.out.println("False");
        }
        else
        {
            System.out.println("True");
            n--;
            sayHi(n);
        }
    }

    public static void countBackwards(int n)
    {
        if(n == 0)
        {
            System.out.println("Done!");
        }
        else
        {
            System.out.println(n);
            n--;
            countBackwards(n);
        }
    }
}
