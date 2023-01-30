package com.example.gamestation;
import java.util.*;

public class Customer
{
    public Customer()
    {

    }

    public Customer(String id, String name, String address, String phone, double money)
    {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.money = money;
    }

    Scanner scan = new Scanner(System.in);
    protected String id;
    protected String name;
    protected String address;
    protected String phone;
    protected double money;

    public String getId()
    {
        return id;
    }

    public void setId()
    {
        String id = "" + (long)(Math.random() * 4000000000L);
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName()
    {
        String nameTemp;
        do
        {
            System.out.print("Enter your name here [5 - 20 Characters]: ");
            nameTemp = scan.nextLine();
            if(nameTemp.length() < 5 || nameTemp.length() > 20)
            {
                System.out.println("Invalid name input!");
            }
        }
        while(nameTemp.length() < 5 || nameTemp.length() > 20);
        this.name = nameTemp;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress()
    {
        String addressTemp;
        do
        {
            System.out.print("Enter your address here [5 - 30 Characters]: ");
            addressTemp = scan.nextLine();
            if(addressTemp.length() < 5 || addressTemp.length() > 30)
            {
                System.out.print("Invalid address input!");
            }
        }
        while(addressTemp.length() < 5 || addressTemp.length() > 30);
        this.address = addressTemp;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone()
    {
        String regex = "^[0-9]{10}$";
        String phoneTemp;
        do
        {
            System.out.print("Enter your phone number: ");
            phoneTemp = scan.nextLine();
        }
        while(phoneTemp.matches(regex));
        this.phone = phoneTemp;
    }

    public double getMoney()
    {
        return money;
    }

    public void setMoney()
    {
        double moneyTemp;
        do
        {
            System.out.print("Input your money here: ");
            moneyTemp = scan.nextDouble();
            scan.nextLine();
            if(moneyTemp < 0 || moneyTemp > 1000000)
            {
                System.out.println("Invalid money input!");
            }
        }
        while (moneyTemp < 0 || moneyTemp> 1000000);
        this.money = moneyTemp;
    }
}
