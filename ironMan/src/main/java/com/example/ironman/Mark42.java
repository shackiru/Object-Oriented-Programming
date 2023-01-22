package com.example.ironman;
import java.util.Scanner;

public class Mark42 extends ironMan
{

    Scanner s2 = new Scanner(System.in);
    private int missile;

    public int getMissile()
    {
        return missile;
    }

    public void setMissile()
    {
        int missileTemp = 0;
        do
        {
            System.out.print("Enter Amount Of Missile [1 - 5]: ");
            missileTemp = s2.nextInt();
            s2.nextLine();
            if(missile < 0)
            {
                System.out.println("Missile Cannot Below Than Zero!");
            }
            else if(missile > 5)
            {
                System.out.println("Missile Cannot Exceed Than 5!");
            }
        }
        while(missile < 0 || missile > 5);
        this.missile = missileTemp;
    }

    public void useMissile()
    {
        if(missile > 0)
        {
            missile--;
        }
        else
        {
            System.out.println("No Missile Left!");
        }
    }
    public void displayMark42()
    {
        displayIronMan();
        System.out.println("Missile : " + getMissile());
    }

    public void selectMark42()
    {
        int choose = 0;
        do
        {
            System.out.println("1. Create Mark 42");
            System.out.println("2. Use Missile");
            System.out.println("3. Display Status");
            System.out.println("4. Go Back");
            System.out.print("Choose Menu: ");
            choose = s2.nextInt();
            s2.nextLine();

            switch (choose)
            {
                case 1:
                {
                    createIronMan();
                    setMissile();
                    break;
                }
                case 2:
                {
                    useMissile();
                    break;
                }
                case 3:
                {
                    displayMark42();
                    break;
                }
                case 4:
                {
                    selectMenu();
                    break;
                }
                default:
                {
                    System.out.println("Input the right number!");
                    break;
                }
            }
        }
        while(true);
    }

}
