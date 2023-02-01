package com.example.school;

public class Person
{
    protected String personID;
    protected String personName;
    protected String username;
    protected String password;

    public Person()
    {

    }

    public Person(String personID, String personName, String username, String password)
    {
        this.personID = personID;
        this.personName = personName;
        this.username = username;
        this.password = password;
    }

    public String getPersonID()
    {
        return personID;
    }

    public void setPersonID(String personID)
    {
        this.personID = personID;
    }

    public String getPersonName()
    {
        return personName;
    }

    public void setPersonName(String personName)
    {
        this.personName = personName;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
