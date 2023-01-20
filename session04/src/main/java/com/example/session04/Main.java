package com.example.session04;

public class Main
{
        public Main()
        {
                Student s = new Student();
                System.out.println("Student name: " + s.getName());
                System.out.println("Student Age: " + s.getAge());
                s.walk();
                s.walk(90);
        }
        public static void main(String[] args)
        {
                new Main();
        }

        public void walk(double a)
        {

        }

        public void walk(int n, double a)
        {

        }
}
