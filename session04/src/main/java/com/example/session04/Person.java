package com.example.session04;

public class Person
{
    protected String name;
    protected int age;

    public Person(String budi)
    {
        System.out.println("Person is created!");
        name = "deni";
    }
    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void walk()
    {
        System.out.println("Person is walking!");
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}
