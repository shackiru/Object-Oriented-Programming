package com.example.schoolsl;
import java.util.ArrayList;
import java.util.Scanner;
public class Display
{
    Scanner scan = new Scanner(System.in);
    Controller c1 = new Controller();
    ArrayList<StudentData> students = new ArrayList<StudentData>();
    public void signInMenu()
    {
        int select = 0;
        do
        {
            System.out.println("1. Student");
            System.out.println("2. Lecturer");
            System.out.println("3. Exit");
            System.out.print("Select: ");
            select = scan.nextInt();
            scan.nextLine();

            switch(select)
            {
                case 1:
                {
                    c1.createStudent();
                    break;
                }
                case 2:
                {
                    c1.createLecturer();
                    break;
                }
                case 3:
                {
                    System.exit(0);
                    break;
                }
                default:
                {
                    System.out.println("Invalid input!");
                    break;
                }
            }
        }
        while(true);
    }
    public void loginMenu()
    {
        int select = 0;
        do
        {
            System.out.print("Input your username: ");
            String username = scan.nextLine();
            System.out.print("Input your password: ");
            String password = scan.nextLine();
            if(c1.checkStudent(username, password))
            {
                studentMenu();
            }
            else if(c1.checkLecturer(username, password))
            {
                lecturerMenu();
            }
            else
            {
                System.out.println("Invalid username or password!");
            }
        }
        while(true);
    }
    public void studentMenu()
    {

    }
    public void lecturerMenu()
    {

    }
}
