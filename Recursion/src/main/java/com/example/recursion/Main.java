package com.example.recursion;

public class Main
{
    public static void main(String[] args)
    {
        Pen p = new Pen();
        Headphones hp = new Headphones();
        Mouse mu = new Mouse();

        mu.scrollUp();
        mu.rightClick();
        System.out.println(mu.texture);

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
