package com.example.session04;

public class Main
{
        public Main()
        {
                Student s = new Student();
                System.out.println("Student name: " + s.getName());
                System.out.println("Student Age: " + s.getAge());
        }
        public static void main(String[] args)
        {
                new Main();
        }
}
