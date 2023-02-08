package com.example.schoolsl;

public class User
{
    protected String username;
    protected String password;
    protected String name;

    public User()
    {

    }

    public User(String username, String password, String name)
    {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
