package com.example.lupitacase;
import java.util.Scanner;

public class Display
{

    Scanner scan = new Scanner(System.in);
    Controller c1 = new Controller();

    public void custMenu()
    {
        int ch = 0;
        do
        {
            System.out.println("Terrace Lupita");
            System.out.println("1. View Menu");
            System.out.println("2. Order Menu");
            System.out.println("3. Search Food");
            System.out.println("4. Exit");
            System.out.println(">> ");
            ch = scan.nextInt();
            scan.nextLine();

            switch(ch)
            {
                case 1:
                {
                    c1.displayFood();
                    break;
                }
                case 2:
                {
                    break;
                }
                case 3:
                {
                    c1.searchFood();
                    break;
                }
                case 4:
                {
                    return;
                }
                default:
                {
                    System.out.println("Wrong selection!");
                    break;
                }
            }
        }
        while(true);
    }
    public void admMenu()
    {
        do {

            int ch = 0;
            System.out.println("Terrace Lupita for Admin");
            System.out.println("1. View Menu");
            System.out.println("2. Add Menu");
            System.out.println("3. Update Menu");
            System.out.println("4. Delete Menu");
            System.out.println("5. Exit");
            System.out.print(">> ");
            ch = scan.nextInt();
            scan.nextLine();

            switch (ch) {
                case 1: {
                    c1.displayFood();
                    break;
                }
                case 2: {
                    c1.createFood();
                    break;
                }
                case 3: {
                    c1.updateAlt();
                    break;
                }
                case 4: {
                    c1.deleteFood();
                    break;
                }
                case 5: {
                    return;
                }
                default: {
                    System.out.println("Wrong selection!");
                    break;
                }
            }
        }
        while(true);
    }
    public void loginMenu() {
        boolean checkLogin = false;
        do
        {
            System.out.print("Enter your username: ");
            String username = scan.nextLine();
            System.out.print("Enter your password: ");
            String password = scan.nextLine();
            if (c1.checkCustomer(username, password) != null) {
                custMenu();
            } else if (c1.checkAdmin(username, password) != null) {
                admMenu();
            } else {
                System.err.println("Username or Password is incorrect");
                System.err.println("Press any key to continue...");
                scan.nextLine();
            }
        }
        while(true);
    }
}
