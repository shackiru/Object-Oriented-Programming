package com.example.gamestation;

import java.util.Scanner;
import java.util.ArrayList;

public class Helper
{
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Customer> customerList = new ArrayList<>();

    public void createCustomer()
    {
        Customer c1 = new Customer();
        c1.setId();
        c1.setName();
        c1.setAddress();
        c1.setPhone();
        c1.setMoney();
        customerList.add(c1);
    }

    public void displayCustomer()
    {
        for(int i = 0; i < customerList.size(); i++)
        {
            Customer c1 = customerList.get(i);
            System.out.println("Customer " + (i + 1));
            System.out.println("ID: " + c1.getId());
            System.out.println("Name: " + c1.getName());
            System.out.println("Address: " + c1.getAddress());
            System.out.println("Phone: " + c1.getPhone());
            System.out.println("Money: " + c1.getMoney());
        }
    }


    public static void Helper(String[] args)
    {
        Helper h1 = new Helper();
        int menu = 0;
        do
        {
            System.out.println("1. Create Customer");
            System.out.println("2. Display Customer");
            System.out.print("Choose Menu >> ");
            menu = scan.nextInt();
            scan.nextLine();

            switch(menu)
            {
                case 1:
                    h1.createCustomer();
                    break;
                case 2:
                    h1.displayCustomer();
                    break;
            }
        }
        while(true);
    }
}
