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

        String n;
        boolean isFalse = true;
        do
        {
            try
            {
                System.out.print("Input a number: ");
                n = sc.nextLine();
                Integer.parseInt(n);
                isFalse = false;
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
                System.out.println("Error Conversion!");
            }
        }
        while(isFalse);
    }
    public static void main(String[] args)
    {
        new Introduction();
        String input;

        String s = "Bina Nusantara";
        System.out.println(s.length()); //Word Length
        System.out.println(s.charAt(0)); //First Letter
        System.out.println(s.charAt(s.length() - 1)); //Last Letter
        System.out.println(s.indexOf('n')); // Count how many "n" in that sentence
        System.out.println(s.substring(0, s.indexOf(' ')));

        //int[] numbers = {1, 2 , 3, 4, 5};
//        for(int i = 0; i < numbers.length; i++)
//        {
//            System.out.println(numbers[i]);
//        }

//        for(int n : numbers)
//        {
//            System.out.println(n);
//        }


    }
    
}
