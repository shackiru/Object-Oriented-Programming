package com.example.schoolsl;

public class Admin extends User
{
    protected String code;

    public Admin()
    {

    }

    public Admin(String username, String password, String name, String code)
    {
        super(username, password, name);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }
}
