package com.example.polymorphism;


public class Swordman extends Troop
{
    protected int swordCount = 5;
    public int getSwordCount()
    {
        System.out.println("Swordman has " + swordCount + " swords!");
        return swordCount;
    }
    public void attack()
    {
        System.out.println("Swordman use sword slash!");
    }

}
