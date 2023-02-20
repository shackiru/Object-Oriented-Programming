package com.example.lupitacase;
import java.util.ArrayList;
import java.util.Scanner;
public class Controller
{
    Scanner scan = new Scanner(System.in);
    ArrayList<Customer> customers = new ArrayList<>();
    ArrayList<Admin> admins = new ArrayList<>();
    public Controller()
    {
        admins.add(new Admin("admin1", "123456"));
    }
}
