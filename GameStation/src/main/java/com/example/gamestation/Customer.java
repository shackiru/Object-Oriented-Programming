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

    public String getId() {
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

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
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
