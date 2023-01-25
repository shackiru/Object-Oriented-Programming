package com.example.gamestation;
import java.util.*;

public class Customer
{
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

    public void setId(String id)
    {
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

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public double getMoney()
    {
        return money;
    }

    public void setMoney(double money)
    {
        this.money = money;
    }
}
