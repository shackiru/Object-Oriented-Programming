package com.example.schoolsl;

public class Subject
{
    protected String name;
    protected String code;
    protected int scu;

    public Subject(String name, String code, int scu)
    {
        this.name = name;
        this.code = code;
        this.scu = scu;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getCode() 
    {
        return code;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }
    public int getScu() 
    {
        return scu;
    }

    public void setScu(int scu)
    {
        this.scu = scu;
    }
}
