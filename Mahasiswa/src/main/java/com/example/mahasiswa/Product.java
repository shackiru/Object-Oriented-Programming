package com.example.mahasiswa;

public class Product
{
    private String name;
    private double price;
    private int stock;
    private int quantity;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public int getStock()
    {
        return stock;
    }

    public void setStock(int stock)
    {
        this.stock = stock;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    public Product()
    {

    }
    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.quantity = quantity;
    }

    public boolean isLowStock()
    {
        if(stock < 10)
        {
            return true;
        }
        return false;
    }

    public void sellProduct(int quantity)
    {
        if(quantity > stock)
        {
            System.out.println("Out of Stock!");
        }
        else
        {
            stock = stock - quantity;
            System.out.println("stock");
        }
    }

    public void print()
    {
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Stock: " + stock);
        System.out.println("Low Stock?" + isLowStock());
    }
}
