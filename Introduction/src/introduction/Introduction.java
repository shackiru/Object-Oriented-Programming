package introduction;

import java.util.Iterator;
import java.util.Scanner;

public class Introduction 
{
    Scanner sc = new Scanner(System.in);
    public Introduction()
    {
        int input;
        String name;

        System.out.print("Input some value: ");
        input = sc.nextInt();
        sc.nextLine();

        System.out.printf("Input your name: ");
        name = sc.nextLine();

        System.out.println("n = " + input + ", Your name is " + name);
    }
    public static void main(String[] args)
    {
        new Introduction();
        int n = 10;
        String input;

        if(n > 5)
        {
            System.out.println("Angka = " + n + " Hebat");
        }

        System.out.println("Hello World");
        System.out.println("Good Evening!");
    }
    
}
