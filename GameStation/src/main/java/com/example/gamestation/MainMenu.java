package com.example.gamestation;
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu
{
    static Scanner scan = new Scanner(System.in);

    ArrayList<Order> orders = new ArrayList<>();
    ArrayList<Customer> customers = new ArrayList<>();
    ArrayList<Employee> employees = new ArrayList<>();
    ArrayList<Game> games = new ArrayList<>();

    Order o = new Order();
    Employee e = new Employee();
    Customer c = new Customer();
    private String gameIDTemp;
    private String gameNameTemp;
    private String gameTypeTemp;
    private String gamePlatformTemp;
    private double gamePriceTemp;
    private int gameQuantityTemp;
    private double orderPriceTemp;
    private String orderStatusTemp;
    private int orderQuantityTemp;

    public void promptEnterKey()
    {
        System.out.println("Press \"ENTER\" to continue...");
        scan.nextLine();
    }
    public void createEmployee()
    {
        String employeeIDTemp = "" + (long) (Math.random() * 4000000000L);
        String employeeNameTemp;
        do
        {
            System.out.print("Enter Employee Name: ");
            employeeNameTemp = scan.nextLine();
            if(employeeNameTemp.length() < 5 || employeeNameTemp.length() > 20)
            {
                System.out.println("Invalid name input!");
            }
        }
        while (employeeNameTemp.length() < 5 || employeeNameTemp.length() > 20);

        e.setEmployeeID(employeeIDTemp);
        e.setEmployeeName(employeeNameTemp);
        employees.add(e);
    }

    public void createCustomer()
    {
        String customerIDTemp = "" + (long) (Math.random() * 4000000000L);
        String customerNameTemp;
        do
        {
            System.out.print("Enter Customer Name: ");
            customerNameTemp = scan.nextLine();
            if(customerNameTemp.length() < 5 || customerNameTemp.length() > 20)
            {
                System.out.println("Invalid name input!");
            }
        }
        while(customerNameTemp.length() < 5 || customerNameTemp.length() > 20);

        String customerAddressTemp;
        do
        {
            System.out.print("Enter Customer Address: ");
            customerAddressTemp = scan.nextLine();
            if(customerAddressTemp.length() < 5 || customerAddressTemp.length() > 20)
            {
                System.out.println("Invalid address input!");
            }
        }
        while(customerAddressTemp.length() < 5 || customerAddressTemp.length() > 20);

        String customerPhoneTemp;
        do
        {
            System.out.print("Enter Customer Phone: ");
            customerPhoneTemp = scan.nextLine();
            if(customerPhoneTemp.length() < 5 || customerPhoneTemp.length() > 20)
            {
                System.out.println("Invalid phone input!");
            }
        }
        while(customerPhoneTemp.length() < 8 || customerPhoneTemp.length() > 11);

        double customerMoneyTemp;
        do
        {
            System.out.print("Enter Customer Money: ");
            customerMoneyTemp = scan.nextDouble();
            if(customerMoneyTemp < 0)
            {
                System.out.println("Invalid money input!");
            }
        }
        while(customerMoneyTemp < 10000 || customerMoneyTemp > 1000000);
    }

    public void displayGame()
    {
        if(games.size() == 0)
        {
            System.out.println("No games available!");
            return;
        }
        else
        {
            for (Game game : games)
            {
                System.out.println("+========================+");
                System.out.println("| Game ID:               | " + game.getGameID());
                System.out.println("| Game Name:             | " + game.getGameName());
                System.out.println("| Game Genre:            | " + game.getGameType());
                System.out.println("| Game Platform:         | " + game.getGamePlatform());
                System.out.println("| Game Price:            | " + game.getGamePrice());
                System.out.println("| Game Quantity:         | " + game.getGameQuantity());
                System.out.println("+========================+");
            }
        }
    }

    public void createOrder()
    {
        if(games.size() == 0)
        {
            System.out.println("No game available!");
            promptEnterKey();
        }
        else
        {
            String orderIDTemp = "" + (long) (Math.random() * 4000000000L);
            displayGame();
            int chooseGame = 0;
            do
            {
                System.out.print("Choose Game: ");
                chooseGame = scan.nextInt();
                if(chooseGame < 0 || chooseGame > games.size())
                {
                    System.out.println("Invalid game input!");
                }
            }
            while(chooseGame < 0 || chooseGame > games.size());
        }
    }

    public void displayEmployeeProfile()
    {
        System.out.println("Employee ID: " + e.getEmployeeID());
        System.out.println("Employee Name: " + e.getEmployeeName());
        promptEnterKey();
    }
    public void EmployeeMenu()
    {
        int select = 0;
        do
        {
            System.out.println("+----------------------+");
            System.out.println("| 1. Add Game          |");
            System.out.println("| 2. Edit Game         |");
            System.out.println("| 3. Delete Game       |");
            System.out.println("| 4. Display Game      |");
            System.out.println("| 5. Create Employee   |");
            System.out.println("| 6. Create Customer   |");
            System.out.println("| 7. Display Customer  |");
            System.out.println("| 8. Profile Detail    |");
            System.out.println("| 9. Exit              |");
            System.out.println("+----------------------+");
            System.out.print("Choose Menu >> ");
            select = scan.nextInt();
            scan.nextLine();

            switch (select)
            {
                case 8:
                {
                    displayEmployeeProfile();
                    break;
                }
            }

        }
        while(true);
    }

    public void customerMenu()
    {
        int select = 0;
        do
        {
            System.out.println("+--------------------------------+");
            System.out.println("| 1. View Game List              |");
            System.out.println("| 2. Buy Game                    |");
            System.out.println("| 3. Update Profile              |");
            System.out.println("| 4. Delete Profile              |");
            System.out.println("| 5. Check Money                 |");
            System.out.println("| 6. Profile Detail              |");
            System.out.println("| 7. Become Member (Rp.50.000)   |");
            System.out.println("| 8. Checkout                    |");
            System.out.println("| 9. Exit                        |");
            System.out.println("+--------------------------------+");
            System.out.print("Choose Menu >> ");
            select = scan.nextInt();
            scan.nextLine();
        }
        while(true);
    }
    public static void mainMenu(String[] args)
    {
        MainMenu m1 = new MainMenu();
        int select = 0;
        do
        {
            System.out.println("+----------------------+");
            System.out.println("| 1. Login as Employee |");
            System.out.println("| 2. Login as Customer |");
            System.out.println("| 3. Exit              |");
            System.out.println("+----------------------+");
            System.out.print("Choose Menu >> ");
            select = scan.nextInt();
            scan.nextLine();

            switch (select)
            {
                case 1:
                    if(m1.employees.size() == 0)
                    {
                        System.out.println("No employee available!");
                        System.out.println("Create employee first!");
                        m1.createEmployee();
                    }
                    m1.EmployeeMenu();
                    break;
                case 2:
                    m1.customerMenu();
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
        while(true);
    }
}
