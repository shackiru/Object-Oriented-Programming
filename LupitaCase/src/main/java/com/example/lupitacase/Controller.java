package com.example.lupitacase;
import java.util.ArrayList;
import java.util.Scanner;
public class Controller
{
    Scanner scan = new Scanner(System.in);
    ArrayList<Customer> customers = new ArrayList<>();
    ArrayList<Admin> admins = new ArrayList<>();
    ArrayList<Food> foods = new ArrayList<>();
    public Controller()
    {
        customers.add(new Customer("shaquille", "shaquille", "SHAQ123"));
        admins.add(new Admin("admin1", "123456"));
        foods.add(new Food("CA1000", "Caramel", 25000, 10));
        foods.add(new Food("RO7001", "Roti Bakar", 10000, 19));
    }
    public boolean checkUser(String username)
    {
        for(Customer i: customers)
        {
            if(i.getUsername().equalsIgnoreCase(username))
            {
                return true;
            }
        }
        for(Admin i: admins)
        {
            if(i.getUsername().equalsIgnoreCase(username))
            {
                return true;
            }
        }
        return false;
    }
    public Customer checkCustomer(String username, String password)
    {
        for(Customer i: customers)
        {
            if(i.getUsername().equalsIgnoreCase(username) && i.getPassword().equals(password))
            {
                return i;
            }
        }
        return null;
    }
    public Admin checkAdmin(String username, String password)
    {
        for(Admin i: admins)
        {
            if(i.getUsername().equalsIgnoreCase(username) && i.getPassword().equals(password))
            {
                return i;
            }
        }
        return null;
    }
    public void signCustomer()
    {
        String usernameTemp;
        String passwordTemp;
        do
        {
            System.out.print("Enter your username [6-20 Characters]: ");
            usernameTemp = scan.nextLine();
            if(checkUser(usernameTemp))
            {
                System.err.println("Username Already Exist!");
                System.err.println("Press any key to continue...");
                scan.nextLine();
            }
            else if(usernameTemp.length() < 6 || usernameTemp.length() > 20)
            {
                System.err.println("Invalid name format!");
                System.err.println("Press any key to continue...");
                scan.nextLine();
            }
            else
            {
                break;
            }
        }
        while(true);
        do
        {
            System.out.print("Enter your password [6-20 Characters]: ");
            passwordTemp = scan.nextLine();
            if(passwordTemp.length() < 6 || passwordTemp.length() > 20)
            {
                System.err.println("Invalid password format!");
                System.err.println("Press any key to continue...");
                scan.nextLine();
            }
        }
        while(true);
    }
    public boolean checkFood(String foodName)
    {
        for(Food i: foods)
        {
            if(i.getFoodName().equalsIgnoreCase(foodName))
            {
                return true;
            }
        }
        return false;
    }
    public boolean checkFoodSearch(String foodName)
    {
        for(Food i: foods)
        {
            if(i.getFoodName().equalsIgnoreCase(foodName))
            {
                return false;
            }
        }
        return true;
    }

    public boolean checkSameFood(String foodName)
    {
        for(Food i: foods)
        {
            if(i.getFoodName().equalsIgnoreCase(foodName))
            {
                return false;
            }
        }
        return true;
    }
    public void createFood()
    {
        String nameTemp;
        int priceTemp;
        int quantityTemp;
        do
        {
            System.out.print("Enter the food name [6-20 Characters: ");
            nameTemp = scan.nextLine();
            if(checkFood(nameTemp))
            {
                System.err.println("Food already exist!");
                System.err.println("Press any key to continue...");
                scan.nextLine();
            }
            else if(nameTemp.length() < 6 || nameTemp.length() > 20)
            {
                System.err.println("Invalid name format!");
                System.err.println("Press any key to continue...");
                scan.nextLine();
            }
            else
            {
                break;
            }
        }
        while(true);
        do
        {
            System.out.print("Enter the food price [7500-50000]: ");
            priceTemp = scan.nextInt();
            scan.nextLine();
            if(priceTemp < 7500 || priceTemp > 50000)
            {
                System.err.println("Invalid price format!");
                System.err.println("Press any key to continue...");
                scan.nextLine();
            }
            else
            {
                break;
            }
        }
        while(true);
        do
        {
            System.out.print("Enter the food quantity [1-20]: ");
            quantityTemp = scan.nextInt();
            scan.nextLine();
            if(quantityTemp < 0 || quantityTemp > 20)
            {
                System.err.println("Invalid quantity format!");
                System.err.println("Press any key to continue...");
                scan.nextLine();
            }
            else
            {
                break;
            }
        }
        while(true);
    }
    public void displayFood()
    {
        int inx = 1;
        System.out.println("Name - Price - Quantity");
        for(Food i: foods)
        {
            System.out.println("Code: " + i.getFoodID());
            System.out.println(inx + ". " + i.getFoodName() + " - " + i.getFoodPrice() + " - " +i.getFoodQuantity());
            inx++;
        }
        System.out.println("Press any key to continue");
        scan.nextLine();
    }
    public void updateFood()
    {
        String nameSearch;
        String nameTemp;
        int priceTemp;
        int quantityTemp;

        do
        {
            System.out.print("Enter menu name: ");
            nameSearch = scan.nextLine();
            int dummy = -1;
            for(int i = 0; i < foods.size(); i++)
            {
                if(nameSearch == foods.get(i).getFoodName())
                {
                    dummy = i;
                }
            }
            if(dummy != -1)
            {
                do
                {
                    System.out.print("Enter updated name [6-20 Characters]: ");
                    nameTemp = scan.nextLine();
                    if(checkFood(nameTemp))
                    {
                        System.err.println("Food already exist!");
                        System.err.println("Press any key to continue...");
                        scan.nextLine();
                    }
                    else if (nameTemp.length() < 6 || nameTemp.length() > 20)
                    {
                        System.err.println("Invalid name format!");
                        System.err.println("Press any key to continue...");
                        scan.nextLine();
                    }
                    else
                    {
                        break;
                    }
                }
                while(true);
                do
                {
                    System.out.print("Enter updated price [7500-50000]: ");
                    priceTemp = scan.nextInt();
                    scan.nextLine();
                    if(priceTemp < 7500 || priceTemp > 50000)
                    {
                        System.err.println("Invalid price format!");
                        System.err.println("Press any key to continue...");
                        scan.nextLine();
                    }
                    else
                    {
                        break;
                    }
                }
                while(true);
                do
                {
                    System.out.print("Enter updated quantity [1 - 20]: ");
                    quantityTemp = scan.nextInt();
                    scan.nextLine();
                    if(quantityTemp < 1 || quantityTemp > 20)
                    {
                        System.err.println("Invalid quantity format!");
                        System.err.println("Press any key to continue...");
                        scan.nextLine();
                    }
                    else
                    {
                        break;
                    }
                }
                while(true);
            }
        }
        while(true);
    }

    public void updateAlt()
    {
        String nameSearch;
        String nameUpd;
        int priceUpd;
        int quantityUpd;

        do
        {
            System.out.print("Enter name to be update: ");
            nameSearch = scan.nextLine();
            if(checkFoodSearch(nameSearch))
            {
                System.err.println("No food found!");
                System.err.println("Press any key to continue");
                scan.nextLine();
            }
            else
            {
                break;
            }
        }
        while(true);
        do
        {
            System.out.print("Enter updated name [6-20 Characters]: ");
            nameUpd = scan.nextLine();
            if(checkFood(nameUpd))
            {
                System.err.println("Name already exist!");
                System.err.println("Press any key to continue...");
                scan.nextLine();
            }
            else if(nameUpd.length() < 6 || nameUpd.length() > 20)
            {
                System.err.println("Invalid name format!");
                System.err.println("Press any key to continue");
                scan.nextLine();
            }
            else
            {
                break;
            }
        }
        while(true);
        do
        {
            System.out.print("Enter updated price [7500-50000]: ");
            priceUpd = scan.nextInt();
            scan.nextLine();
            if(priceUpd < 7500 || priceUpd > 50000)
            {
                System.err.println("Invalid price format!");
                System.err.println("Press any key to continue...");
                scan.nextLine();
            }
            else
            {
                break;
            }
        }
        while(true);
        do
        {
            System.out.print("Enter updated quantity [1 - 20]: ");
            quantityUpd = scan.nextInt();
            scan.nextLine();
            if(quantityUpd < 1 || quantityUpd > 20)
            {
                System.err.println("Invalid quantity format!");
                System.err.println("Press any key to continue...");
                scan.nextLine();
            }
            else
            {
                break;
            }
        }
        while(true);
        for(Food x: foods)
        {
            if(x.getFoodName().equals(nameSearch))
            {
                x.setFoodName(nameUpd);
                x.setFoodPrice(priceUpd);
                x.setFoodQuantity(quantityUpd);
            }
        }
    }
    public void deleteFood()
    {

    }
    public void orderFood()
    {

    }

    public void searchFood()
    {

    }

    public void login()
    {
        System.out.print("Input your username: ");
        String username = scan.nextLine();
        System.out.print("Input your password: ");
        String password = scan.nextLine();

    }
}
