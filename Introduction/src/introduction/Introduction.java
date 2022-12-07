package introduction;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

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
        //new Introduction();
        String input;

        System.out.println("Hello World");
        System.out.println("Good Evening!");

        int[] numbers = {1, 2 , 3, 4, 5};
//        for(int i = 0; i < numbers.length; i++)
//        {
//            System.out.println(numbers[i]);
//        }

        for(int n : numbers)
        {
            System.out.println(n);
        }
    }
    
}
