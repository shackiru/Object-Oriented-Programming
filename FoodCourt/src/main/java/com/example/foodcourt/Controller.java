package com.example.foodcourt;
import com.example.foodcourt.Model.Food;


import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Controller
{
    Scanner scan = new Scanner(System.in);
    ArrayList<Model.Order> orders = new ArrayList<>();
     ArrayList<Model.Menu> menus = new ArrayList<>();
     ArrayList<Model.Food> foods = new ArrayList<>();



    public void createFood()
    {
        String whatTemp = "";
        String nameTemp = "";
        int priceTemp;
        String typeTemp;
        String originTemp = "";
        do
        {
            System.out.print("What menu do you want to add [Food | Drink]: ");
            whatTemp = scan.nextLine();
            if(!whatTemp.equals("Food") && !whatTemp.equals("Drink"))
            {
                System.err.println("Choose between food and drink!");
                System.out.println("Press ANY Key to continue...");
                scan.nextLine();
            }
        }
        while (!whatTemp.equals("Food") && !whatTemp.equals("Drink"));

        if(whatTemp.equals("Food"))
        {
            do
            {
                System.out.print("Food Name [Name Must be Filled]: ");
                nameTemp = scan.nextLine();
                if(nameTemp.equals(""))
                {
                    System.err.println("Name must be fiiled!");
                    System.out.println("Press ANY Key to continue...");
                    scan.nextLine();
                }
            }
            while (nameTemp.equals(""));

            do
            {
                System.out.print("Food Price [>=1000]: ");
                priceTemp = scan.nextInt();
                scan.nextLine();
                if(priceTemp < 1000)
                {
                    System.err.println("Price must be >=1000");
                    System.out.println("Press ANY Key to continue...");
                    scan.nextLine();
                }
            }
            while(priceTemp <= 1000);

            do
            {
                System.out.print("Food Type [ Rice | Noodle ]: ");
                typeTemp = scan.nextLine();
                if(!typeTemp.equals("Rice") && !typeTemp.equals("Noodle"))
                {
                    System.err.println("Choose between Rice and Noodle");
                    System.out.println("Press ANY Key to continue...");
                    scan.nextLine();
                }
            }
            while(!typeTemp.equals("Rice") && !typeTemp.equals("Noodle"));

            do
            {
                System.out.print("Food Origin [Must be filled]: ");
                originTemp = scan.nextLine();
                if(originTemp.equals(""))
                {
                    System.err.println("Origin must be filled!");
                    System.out.println("Press ANY Key to continue...");
                    scan.nextLine();
                }
            }
            while(originTemp.equals(""));

            System.out.println(nameTemp);
            System.out.println(priceTemp);
            System.out.println(typeTemp);


            menus.add(new Model(). new Food(whatTemp, priceTemp,nameTemp, typeTemp, originTemp));
        }

    }

    public void viewMenu()
    {
        String whatTemp;
        do
        {
            System.out.print("What menu do you want to add [Food | Drink]: ");
            whatTemp = scan.nextLine();
            if(!whatTemp.equals("Food") && !whatTemp.equals("Drink"))
            {
                System.err.println("Choose between food and drink!");
                System.out.println("Press ANY Key to continue...");
                scan.nextLine();
            }
        }
        while (!whatTemp.equals("Food") && !whatTemp.equals("Drink"));
        if(whatTemp.equals("Food"))
        {
            for(Model.Menu m : menus)
            {
                for (Model.Menu in Food)
                {
                    System.out.println(m.getWhatType());
                    System.out.println(f.getFoodName());
                    System.out.println(f.getFoodOrigin());
                }
            }
        }

    }

    public void updateFood()
    {

    }



    public static void main(String[] args)
    {
        Controller c = new Controller();
        c.createFood();
        c.viewMenu();
    }
}
