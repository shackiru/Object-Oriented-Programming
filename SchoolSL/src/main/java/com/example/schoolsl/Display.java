package com.example.schoolsl;
import java.util.ArrayList;
import java.util.Scanner;
public class Display
{
    Scanner scan = new Scanner(System.in);

    Controller c1 = new Controller();
    public void selectMainMenu()
    {
        int select = 0;
        do
        {
            System.out.println("1. Login");
            System.out.println("2. Sign Up");
            System.out.println("3. Exit");
            System.out.print("Select: ");
            select = scan.nextInt();
            scan.nextLine();

            switch(select)
            {
                case 1:
                {
                    if(c1.students.isEmpty() && c1.lecturers.isEmpty())
                    {
                        System.out.println("There is no user! Press any key to create user...");
                        scan.nextLine();
                        signUpMenu();
                        break;
                    }
                    else
                    {
                        loginMenu();
                    }
                    break;
                }
                case 2:
                {
                    signUpMenu();
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
    public void signUpMenu()
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
                    return;
                }
                case 2:
                {
                    c1.createLecturer();
                    return;
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
            if(c1.checkStudent(username, password) != null)
            {
//                c1.checkStudent(username, password).setPassword("5555555");
//                System.out.println(c1.students.get(0).getPassword());
                studentMenu();
            }
            else if(c1.checkLecturer(username, password) != null)
            {
                lecturerMenu();
            }
        }
        while(true);
    }
    public void studentMenu()
    {
        do
        {
            System.out.println("1. View Profile");
            System.out.println("2. View Score");
            System.out.println("3. View Class");
            System.out.println("4. View Subject");
            System.out.println("5. Search Class");
            System.out.println("6. Search Subject");
            System.out.println("7. Search Student");
            System.out.println("8. Search Lecturer");
            System.out.println("9. Exit");
            System.out.print("Select: ");
            int select = scan.nextInt();
            scan.nextLine();

            switch(select)
            {
                case 1:
                {
                    c1.displayStudent();
                    break;
                }
                case 2:
                {
                    c1.displayStudentScore();
                    break;
                }
                case 3:
                {
                    c1.displayClass();
                    break;
                }
                case 4:
                {
                    c1.displaySubject();
                    break;
                }
                case 5:
                {
                    c1.searchClass();
                    break;
                }
                case 6:
                {
                    c1.searchSubject();
                    break;
                }
                case 7:
                {
                    c1.searchStudent();
                    break;
                }
                case 8:
                {
                    c1.searchLecturer();
                    break;
                }
                case 9:
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
    public void lecturerMenu()
    {
        do
        {
            System.out.println("1. Display All Score");
            System.out.println("2. Display All Class");
            System.out.println("3. Display All Subject");
            System.out.println("4. Display All Student");
            System.out.println("5. Display All Lecturer");
            System.out.println("6. Input Student Score");
            System.out.println("7. Create Class");
            System.out.println("8. Create Subject");
            System.out.println("9. Update Student");
            System.out.println("10. Update Student Score");
            System.out.println("11. Update Class");
            System.out.println("12. Update Subject");
            System.out.println("13. Delete Student");
            System.out.println("14. Delete Student Score");
            System.out.println("15. Delete Class");
            System.out.println("16. Delete Subject");
            System.out.println("17. Search Score");
            System.out.println("18. Logout");
            System.out.print("Select: ");
            int select = scan.nextInt();
            scan.nextLine();

            switch(select)
            {
                case 1:
                {
                    c1.displayAllScore();
                    break;
                }
                case 2:
                {
                    c1.displayClass();
                    break;
                }
                case 3:
                {
                    if(c1.subjects.isEmpty())
                    {
                        System.out.println("There is no subject! Press any key to continue...");
                    }
                    else
                    {
                        c1.displaySubject();
                        System.out.println("Press ENTER to continue...");
                    }
                    scan.nextLine();
                    break;
                }
                case 4:
                {
                    if(c1.students.isEmpty())
                    {
                        System.out.println("There is no student! Press any key to continue...");
                    }
                    else
                    {
                        c1.displayAllStudent();
                        System.out.println("Press ENTER to continue...");
                    }
                    scan.nextLine();
                    break;
                }
                case 5:
                {
                    c1.displayLecturer();
                    break;
                }
                case 6:
                {
                    c1.createScore();
                    break;
                }
                case 7:
                {
                    c1.createClass();
                    break;
                }
                case 8:
                {
                    c1.createSubject();
                    break;
                }
                case 9:
                {
                    c1.updateStudent();
                    break;
                }
                case 10:
                {
                    c1.updateScore();
                    break;
                }
                case 11:
                {
                    c1.updateClass();
                    break;
                }
                case 12:
                {
                    c1.updateSubject();
                    break;
                }
                case 13:
                {
                    c1.deleteStudent();
                    break;
                }
                case 14:
                {
                    c1.deleteScore();
                    break;
                }
                case 15:
                {
                    c1.deleteClass();
                    break;
                }
                case 16:
                {
                    c1.deleteSubject();
                    break;
                }
                case 17:
                {
                    c1.searchScore();
                    break;
                }
                case 18:
                {
                    return;
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

    public static void display(String[] args)
    {
        Display d1 = new Display();
        d1.selectMainMenu();
    }
}
