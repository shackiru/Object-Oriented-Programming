package com.example.polymorphism;

import java.util.ArrayList;

public class Batalyon extends Troop
{
    private ArrayList<Archer> archers = new ArrayList<>();
    private ArrayList<Swordman> swordmen = new ArrayList<>();

    public ArrayList<Archer> getAllArcher()
    {
        return archers;
    }

}
