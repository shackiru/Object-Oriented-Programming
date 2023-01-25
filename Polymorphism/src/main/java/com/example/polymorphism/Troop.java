package com.example.polymorphism;

public class Troop
{
    protected int health;
    protected int dmg;

    public void attack()
    {
        System.out.println("Random Attack");
    }

    public void attack(String target)
    {
        System.out.println("Attacking " + target + "!");
    }
}
