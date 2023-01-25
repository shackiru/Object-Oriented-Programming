package com.example.ironman;

import java.util.Scanner;

public class ironMan
{
    Scanner s1 = new Scanner(System.in);

    private int hp;
    private int energy;
    private double damage;
    private String name;

    public int getHp()
    {
        return hp;
    }

    public void setHp()
    {
        int hpTemp = 0;
        do
        {
            System.out.print("Input Iron Man HP [1 - 500]: ");
            hpTemp = s1.nextInt();
            s1.nextLine();
            if(hpTemp > 500)
            {
                System.out.println("HP Cannot Exceed Than 500!");
            }
            else if(hpTemp < 0)
            {
                System.out.println("HP Cannot Below Zero!");
            }
        }
        while(hp < 0 || hp > 500);
        this.hp = hpTemp;
    }

    public int getEnergy()
    {
        return energy;
    }

    public void setEnergy()
    {
        int energyTemp = 0;
        do
        {
            System.out.print("Input Iron Man Energy [1 - 250]: ");
            energyTemp = s1.nextInt();
            s1.nextLine();
            if(energyTemp < 0)
            {
                System.out.println("Energy Cannot Below Zero!");
            }
            else if(energyTemp > 250)
            {
                System.out.println("Energy Cannot Exceed Than 250!");
            }
        }
        while(energyTemp < 0 || energyTemp > 250);
        this.energy = energyTemp;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage()
    {
        double damageTemp;
        do
        {
            System.out.print("Enter Your Iron Man Set Damage [1 - 20]: ");
            damageTemp = s1.nextDouble();
            s1.nextLine();
            if(damageTemp < 0)
            {
                System.out.println("Damage Cannot Below Than Zero!");
            }
            else if(damageTemp > 20.0)
            {
                System.out.println("Damage Cannot Exceed Than 20!");
            }
        }
        while(damageTemp < 0 || damageTemp > 20.0);
        this.damage = damageTemp;
    }

    public String getName()
    {
        return name;
    }

    public void setName()
    {
        String nameTemp;
        do
        {
            System.out.print("Enter Your Iron Man Name [Classic | Mark 42]: ");
            nameTemp = s1.nextLine();
            if(nameTemp.compareTo("Classic") != 0 && nameTemp.compareTo("Mark 42") != 0)
            {
                System.out.println("Input The Right Name!");
            }
        }
        while(nameTemp.compareTo("Classic") != 0 && nameTemp.compareTo("Mark 42") != 0);
        this.name = nameTemp;
    }


    public void useHeal()
    {
        if(hp <= 450)
        {
            hp = hp + 50;
            System.out.println("HP: " + getHp());
        }
        else
        {
            System.out.println("HP Cannot Exceed than 500!");
            System.out.println("HP: " + getHp());
        }
    }
    public void useRecharge()
    {
        if (energy >= 50)
        {
            energy = energy - 50;
            double plusDamage;
            plusDamage = damage * 0.1;
            if(damage + plusDamage > 20)
            {
                damage = 20;
                System.out.println("Energy: " + energy);
                System.out.println("Damage: " + damage);
            }
            else
            {
                damage = damage + plusDamage;
                System.out.println("Energy: " + energy);
                System.out.println("Damage: " + damage);
            }
        }
        else
        {
            System.out.println("Ran out of energy!");
            System.out.println("Energy: " + energy);
            System.out.println("Damage: " + damage);
        }
    }

    public void createIronMan()
    {
        setName();
        setHp();
        setEnergy();
        setDamage();
    }

    public void displayIronMan()
    {
        System.out.println("Name    : " + getName());
        System.out.println("HP      : " + getHp());
        System.out.println("Energy  : " + getEnergy());
        System.out.println("Damage  : " + getDamage());
    }

    public void selectMenu()
    {
        int menu = 0;
        Mark42 m42 = new Mark42();
        do
        {
            System.out.println("1. Create new Iron Man");
            System.out.println("2. Use Heal");
            System.out.println("3. Use Recharge");
            System.out.println("4. Display Status");
            System.out.println("5. Mark 42");
            System.out.print("Choose menu [1 - 4]: ");
            menu = s1.nextInt();
            s1.nextLine();
            switch (menu)
            {
                case 1:
                {
                    createIronMan();
                    break;
                }
                case 2:
                {
                    useHeal();
                    break;
                }
                case 3:
                {
                    useRecharge();
                    break;
                }
                case 4:
                {
                    displayIronMan();
                    break;
                }
                case 5:
                {
                    m42.selectMark42();
                    break;
                }
                default:
                {
                    System.out.println("Please input the right menu!");
                    break;
                }
            }
        }
        while(true);
    }

}
