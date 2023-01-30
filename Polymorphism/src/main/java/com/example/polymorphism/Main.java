package com.example.polymorphism;

import java.util.ArrayList;
import java.util.Vector;

public class Main
{
    public Main()
    {
        ArrayList<Swordman> x = new ArrayList<>();
        x.add(new Swordman());

        //Troop troop = new Swordman();
        // untuk pemanggilan spesifik sebuah child
        ArrayList<Troop> troops = new ArrayList<>();
        troops.add(new Archer());
        troops.add(new Swordman());

        troops.get(0).attack();
        troops.get(1).attack();

        System.out.println(troops.get(0) instanceof Archer);

        if(troops.get(0) instanceof Swordman)
        {
            ((Swordman)troops.get(0)).getSwordCount();
        }

        ArrayList<Batalyon> armies = new ArrayList<>();
        armies.get(0).getAllArcher().get(0).attack();
    }
    public static void main(String[] args)
    {
        new Main();
    }
}
