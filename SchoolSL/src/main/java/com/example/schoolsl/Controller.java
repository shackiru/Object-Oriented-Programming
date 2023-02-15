package com.example.schoolsl;

    import java.util.ArrayList;
    import java.util.Scanner;
public class Controller
{
    Scanner scan = new Scanner(System.in);
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<ClassData> classes = new ArrayList<>();
    ArrayList<Subject> subjects = new ArrayList<>();
    ArrayList<Score> scores = new ArrayList<>();
    ArrayList<Lecturer> lecturers = new ArrayList<>();
    ArrayList<Admin> admins = new ArrayList();


    static int nimTemp = 260000;
    static int nikTemp = 200000;
    static int codeTemp = 250000;
    public Controller()
    {
        admins.add(new Admin("admin1", "admin123", "admin", "A02"));
    }
    public void createStudent()
    {
        String usernameTemp;
        String passwordTemp;
        String nameTemp;
        do
        {
            System.out.print("Input your username: ");
            usernameTemp = scan.nextLine();
            if(checkUsernameExist(usernameTemp))
            {
                System.err.println("Username already exist!");
                System.err.println("Press ENTER to continue...");
                scan.nextLine();
            }
            else if(usernameTemp.length() < 6)
            {
                System.err.println("Username must be at least 6 characters!");
                System.err.println("Press ENTER to continue...");
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
            System.out.print("Input your password: ");
            passwordTemp = scan.nextLine();
            if(passwordTemp.length() < 6)
            {
                System.err.println("Password must be at least 6 characters!");
                System.err.println("Press ENTER to continue...");
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
            System.out.print("Input your name: ");
            nameTemp = scan.nextLine();
            if(nameTemp.length() < 6)
            {
                System.err.println("Name must be at least 6 characters!");
                System.err.println("Press ENTER to continue...");
                scan.nextLine();
            }
            else
            {
                break;
            }
        }
        while(true);
        students.add(new Student(usernameTemp, passwordTemp, nameTemp, nimTemp++));
        System.out.println("Student created!\nPress ENTER to continue...");
        scan.nextLine();
    }
    public boolean checkUsernameExist(String username)
    {
        for(Student i: students)
        {
            if(i.getUsername().equalsIgnoreCase(username))
            {
                return true;
            }
        }
        for(Lecturer i: lecturers)
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
    public void createLecturer()
    {
        String usernameTemp;
        String passwordTemp;
        String nameTemp;
        do
        {
            System.out.print("Input the Lecturer Username: ");
            usernameTemp = scan.nextLine();
            if(checkUsernameExist(usernameTemp))
            {
                System.err.println("Username already exist!");
                System.err.println("Press ENTER to continue...");
                scan.nextLine();
            }
            else if(usernameTemp.length() < 6 || usernameTemp.length() > 15)
            {
                System.err.println("Username must be at least 6 characters!");
                System.err.println("Press ENTER to continue...");
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
            System.out.print("Input the Lecturer Password: ");
            passwordTemp = scan.nextLine();
            if(passwordTemp.length() < 6)
            {
                System.err.println("Password must be at least 6 characters!");
                System.err.println("Press ENTER to continue...");
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
            System.out.print("Input Lecturer Name: ");
            nameTemp = scan.nextLine();
            if(nameTemp.length() < 6)
            {
                System.err.println("Name must be at least 6 characters!");
                System.err.println("Press ENTER to continue...");
                scan.nextLine();
            }
            else
            {
                break;
            }
        }
        while(true);
        lecturers.add(new Lecturer(usernameTemp, passwordTemp, nameTemp, nikTemp++));
        System.out.println("Lecturer created!\nPress ENTER to continue...");
        scan.nextLine();
    }

    public void deleteLecturer()
    {

    }

    public void createSubject()
    {
        String nameTemp;
        String codeTemp;
        int scuTemp;

        do
        {
            System.out.print("Enter the class code: ");
            codeTemp = scan.nextLine();
            if(checkSubjectCode(codeTemp))
            {
                System.err.println("Class Code Already Exist");
                System.err.println("Press ENTER to continue...");
                scan.nextLine();
            }
            else if(codeTemp.length() > 4)
            {
                System.err.println("Name cannot exceed than 4 characters");
                System.err.println("Press ENTER to continue...");
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
            System.out.print("Input subject name: ");
            nameTemp = scan.nextLine();
            if(checkSubject(nameTemp))
            {
                System.err.println("Subject Already Exist!");
                System.err.println("Press ENTER to continue...");
                scan.nextLine();
            }
            else if(nameTemp.length() < 8)
            {
                System.err.println("Name Must Be 8 Characters or above!");
                System.err.println("Press ENTER to continue...");
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
            System.out.print("Enter the SCU [2 - 8]: ");
            scuTemp = scan.nextInt();
            scan.nextLine();
            if(scuTemp < 2)
            {
                System.err.println("SCU cannot below than 2!");
                System.err.println("Press ENTER to continue...");
                scan.nextLine();
            }
            else if(scuTemp > 8)
            {
                System.err.println("SCU cannot exceed than 8!");
                System.err.println("Press ENTER to continue...");
                scan.nextLine();
            }
            else
            {
                break;
            }
        }
        while(true);
        subjects.add(new Subject(nameTemp, codeTemp, scuTemp));
        System.out.println("Subject created!\nPress ENTER to continue...");
    }
    public void createScore()
    {

    }
    public void createClass()
    {

    }

    public boolean checkSubject(String name)
    {
        for(Subject i: subjects)
        {
            if(i.getName().equalsIgnoreCase(name))
            {
                return true;
            }
        }
        return false;
    }
    public boolean checkSubjectCode(String code)
    {
        for(Subject i: subjects)
        {
            if(i.getName().equalsIgnoreCase(code))
            {
                return true;
            }
        }
        return false;
    }

    public Student checkStudent(String username, String password)
    {
        for(Student i: students)
        {
            System.out.println("Hallo " + i.getName());
            if(i.getUsername().equalsIgnoreCase(username) && i.getPassword().equals(password))
            {
                return i;
            }
        }
        return null;
    }

    public Lecturer checkLecturer(String username, String password)
    {
        for(Lecturer i: lecturers)
        {
            System.out.println("Welcome Our " + i.getName());
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
            System.out.println("Konnichiwa " + i.getName());
            if(i.getUsername().equalsIgnoreCase(username) && i.getPassword().equals(password))
            {
                return i;
            }
        }
        return null;
    }

    public void displayAllScore()
    {

    }
    public void displayStudentScore()
    {

    }
    public void displayClass()
    {

    }
    public void displaySubject()
    {

    }
    public void displayStudent()
    {
        for(Student i: students)
        {
            System.out.println(i.getName());
            System.out.println(i.getNim());
        }
    }
    public void displayLecturer()
    {

    }
    public void updateStudent()
    {
        int select = 0;
        if(students.isEmpty())
        {
            System.err.println("No Student Found!");
            System.err.println("Press ENTER to continue...");
            scan.nextLine();
            return;
        }
        displayStudent();
        do
        {
            try
            {
                System.out.print("Select Student: ");
                select = scan.nextInt();
                scan.nextLine();
            }
            catch(Exception e)
            {
                scan.nextLine();
                System.out.println("Invalid Input!");
                System.out.println("Press ENTER to continue...");
            }
            String nameTemp = "";
            System.out.print("Enter the new name: ");
            nameTemp = scan.nextLine();
            students.get(select - 1).setName(nameTemp);
        }
        while(true);


//        else
//        {
//            System.err.println("NIM not found!");
//        }
    }
    public void updateScore()
    {

    }
    public void updateClass()
    {

    }
    public void updateSubject()
    {

    }
    public void updateLecturer()
    {

    }
    public void deleteStudent()
    {

    }
    public void deleteScore()
    {

    }
    public void deleteClass()
    {

    }
    public void deleteSubject()
    {

    }
    public void searchStudent()
    {

    }
    public void searchScore()
    {

    }
    public void searchClass()
    {

    }
    public void searchSubject()
    {

    }
    public void searchLecturer()
    {

    }

    public void displayAllStudent()
    {

    }

    public static void main(String[] args)
    {
        Controller c1 = new Controller();
        for(int i = 0; i < 6; i++)
        {
            c1.createStudent();
            c1.displayStudent();
        }

    }
}
