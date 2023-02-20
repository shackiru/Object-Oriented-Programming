package com.example.lupitacase;

import java.util.ArrayList;

public class Order
{
    private Customer customer;
    ArrayList<Food> foods = new ArrayList<>();

    public Order(Customer customer, ArrayList<Food> foods)
    {
        this.customer = customer;
        this.foods = foods;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    public ArrayList<Food> getFoods()
    {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods)
    {
        this.foods = foods;
    }
}
