package shaq.food2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<Menu> menus = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>()
    Scanner scan = new Scanner(System.in);
    public void createFood()
    {
        String name = "";
        int price;
        String type;
        String origin= "";

        do {
            System.out.print("Food name [Must be filled]: ");
            name = scan.nextLine();
            if(name.equals(""))
            {
                System.err.println("Name must filled!");
                System.out.println("Press ANY key to continue...");
                scan.nextLine();
            }
        }while(name.equals(""));
        do {
            System.out.print("Food Price [>=1000]: ");
            price = scan.nextInt();
            scan.nextLine();
            if(price <= 1000)
            {
                System.err.println("Price must be =< 1000!");
                System.out.println("Press ANY key to continue...");
                scan.nextLine();
            }
        }while (price <= 1000);
        do {
            System.out.print("Food Type [Rice|Noodle]: ");
            type = scan.nextLine();
            if (!type.equals("Rice") && !type.equals("Noodle"))
            {
                System.err.println("Choose between Rice or Noodle!");
                System.out.println("Press ANY key to continue...");
                scan.nextLine();
            }
        }while (!type.equals("Rice") && !type.equals("Noodle"));
        do {
            System.out.print("Food Origin [Must be filled]: ");
            origin = scan.nextLine();
            if(origin.equals(""))
            {
                System.err.println("Origin must filled!");
                System.out.println("Press ANY key to continue...");
                scan.nextLine();
            }
        }while (origin.equals(""));
        menus.add(new Food(name, price, type, origin));
    }
    public void createDrink()
    {
        String name;
        int price;
        String flavor;
        String ingredients;

        do {
            System.out.print("Food name [Must be filled]: ");
            name = scan.nextLine();
            if(name.equals(""))
            {
                System.err.println("Name must filled!");
                System.out.println("Press ANY key to continue...");
                scan.nextLine();
            }
        }while(name.equals(""));
        do {
            System.out.print("Food Price [>=1000]: ");
            price = scan.nextInt();
            scan.nextLine();
            if(price <= 1000)
            {
                System.err.println("Price must be =< 1000!");
                System.out.println("Press ANY key to continue...");
                scan.nextLine();
            }
        }while (price <= 1000);
        do {
            System.out.print("Food Type [Rice|Noodle]: ");
            flavor = scan.nextLine();
            if (!flavor.equals("Sweet") && !flavor.equals("Sour"))
            {
                System.err.println("Choose between Sweet or Sour!");
                System.out.println("Press ANY key to continue...");
                scan.nextLine();
            }
        }while (!flavor.equals("Rice") && !flavor.equals("Noodle"));
        do {
            System.out.print("Drink Ingredients [Must be filled]: ");
            ingredients = scan.nextLine();
            if(ingredients.equals(""))
            {
                System.err.println("Ingredients must filled!");
                System.out.println("Press ANY key to continue...");
                scan.nextLine();
            }
        }while (ingredients.equals(""));
        menus.add(new Drink(name, price, flavor, ingredients));
    }

    public void viewMenu()
    {
        for(Menu m : menus)
        {
            if(m.getClass().getName().equals("Food"))
            {
                System.out.println("Food Name: " + m.getName());
                System.out.println("Food Price: " + m.getPrice());
                System.out.println("Food Type: " + ((Food)m).getType();
                System.out.println("Food Origin: " + ((Food)m).getOrigin();
            }
            else
            {
                if(m instanceof Drink)
                {
                    System.out.println("Drink Name: " + m.getName());
                    System.out.println("Drink Price: " + m.getPrice());
                    System.out.println("Drink Flavor: " + ((Drink)m).getFlavor();
                    System.out.println("Drink Ingredients: " + ((Drink)m).getIngredients();
                }
            }
        }
    }

    public void editPrice()
    {
        viewMenu();
        int flag = 0;
        String name = "";
        int price = 0;

        do {
            flag = 0;
            System.out.print("Menu name: ");
            name = scan.nextLine();
            for(Menu m : menus)
            {
                if(m.getName().equals(name))
                {
                    flag = 1;
                }
            }
        }while(flag == 0 || name.equals(""));
        try {
            do {
                System.out.print("New Price: ");
                price = scan.nextInt();
                scan.nextLine();
            }while (price <= 1000);
        }
        catch (Exception e)
        {

        }
        for(Menu m : menus)
        {
            if(m.getName().equals(name))
            {
                m.setPrice(price);
            }
        }
    }

    public void removeMenu()
    {
        int flag;
        String name = "";

        do {
            flag = 0;
            System.out.print("Menu name");
            name = scan.nextLine();
            for(Menu m : menus)
            {
                if(m.getName().equals(name))
                {
                    menus.remove(m);
                    flag = 1;
                    break;
                }
            }
        }while (flag == 0 || name.equals(""));
    }

    public void addMenu()
    {
        String type = "";
        do {
            System.out.print("What menu do you want [Food | Drink]: ");
            type = scan.nextLine();
        }while (!type.equals("Food") && !type.equals("Drink"));
        if (type.equals("Food"))
        {
            createFood();
        }
        else
        {
            createDrink();
        }
    }

    public void foodOrder(Menu m)
    {
        int quantity;
        String size;
        String topping;

        try {
            do {
                System.out.print("Menu quantity: ");
                quantity = scan.nextInt();
                scan.nextLine();
            }while (quantity < 1);
        }
        catch (Exception e)
        {

        }

        do {
            System.out.print("Select size [Small | Medium | Large]: ");
            size = scan.nextLine();
        }while (!size.equals("Small") && !size.equals("Medium")- && !size.equals("Large"));

        do {
            System.out.print("Menu topping");
            topping = scan.nextLine();
        }while (!topping.equals("Egg") && !topping.equals("Sausage"));

        orders.add(new Order(m, quantity,quantity * m.getPrice(), size, topping));
    }

    public void addOrder()
    {
        viewMenu();
        String name;
        int flag = 0;

        do {
            flag = 0;
            System.out.print("Menu name");
            name = scan.nextLine();

            for(Menu m : menus)
            {
                if(m.getName().equals("Food"))
                {
                    foodOrder();
                }
                else
                {
                    drinkOrder();
                }
            }
        }
    }
}


