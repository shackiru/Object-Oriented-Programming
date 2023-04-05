package com.example.javagui;

public class Threading
{
    public Threading()
    {
        for(int i = 0; i < 10; i++)
        {
            System.out.println("Hello World");
        }

        for(int i= 0; i < 10; i++)
        {
            System.out.println("Good Morning!");
        }
    }
    public static void main(String[] args)
    {
        new Threading();
    }
}
