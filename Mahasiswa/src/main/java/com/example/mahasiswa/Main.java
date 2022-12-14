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
        System.out.print("Input Width: ");
        a = sc.nextInt();
        sc.nextLine();
        System.out.print("Input Height: ");
        b = sc.nextInt();
        sc.nextLine();
        Rectangle r2 = new Rectangle(a,b);
        r2.print();

        Product p1 = new Product();
        System.out.print("Input Name: ");
        p1.setName(sc.nextLine());

        System.out.print("Input Price: ");
        p1.setPrice(sc.nextDouble());
        sc.nextLine();

        System.out.print("Input Stock: ");
        p1.setStock(sc.nextInt());
        sc.nextLine();

        System.out.println("Name: " + p1.getName());
        System.out.println("Price: " + p1.getPrice());
        System.out.println("Stock: " + p1.getStock());

        String name;
        double price;
        int stock;

        System.out.print("Input Name: ");
        name = sc.nextLine();

        System.out.print("Input Price: ");
        price = sc.nextDouble();
        sc.nextLine();

        System.out.print("Input Stock: ");
        stock = sc.nextInt();
        sc.nextLine();

        Product p2 =  new Product(name, price, stock);
        p2.print();
    }


    public static void main(String[] args)
    {
        new Main();
    }

}
