package com.example.polymorphism;

public class Main
{
    public Main()
    {
        Troop t1 = new Troop();
        t1.attack();

        Swordman swordman = new Swordman();
        swordman.attack();
    }
    public static void main(String[] args)
    {
        new Main();
    }
}
