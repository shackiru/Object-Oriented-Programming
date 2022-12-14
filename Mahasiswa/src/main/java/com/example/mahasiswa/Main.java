package com.example.mahasiswa;


import java.util.Scanner;

public class Main
{
    public Main()
    {
        Rectangle r1 = new Rectangle();
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Width: ");
        r1.setWidth(sc.nextInt());
        sc.nextLine();

        System.out.print("Input Height: ");
        r1.setHeight(sc.nextInt());
        sc.nextLine();

        System.out.println("Width: " + r1.getWidth());
        System.out.println("Height: " + r1.getHeight());
        System.out.println("Area: " + r1.getArea());
        System.out.println("Around: " + r1.getAround());

        int a = 0;
        int b = 0;
        a = sc.nextInt();
        b = sc.nextInt();
        Rectangle r2 = new Rectangle(a,b);

        r2.print();
    }


    public static void main(String[] args)
    {
        new Main();
    }

}
