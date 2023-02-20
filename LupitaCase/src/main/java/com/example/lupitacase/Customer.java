package com.example.lupitacase;

public class Customer extends User
{
    protected String id;
    public Customer()
    {

    }
    public Customer(String username, String password, String id)
    {
        super(username, password);
        this.id = id;
    }
    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }
}
