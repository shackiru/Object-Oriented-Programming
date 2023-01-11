package com.example.recursion;

public class Headphones
{
    String charge = "Micro USB";
    String controls[] = {"Power", "Volume", "Skip", "Play"};
    String color = "Red/Black";

    static boolean power = false;
    static int volume = 0;

    public static void powerOn()
    {
        power = true;
    }

    public static void powerOff()
    {
        power = false;
    }

    public static void volumeUp()
    {
        volume++;
    }

    public static void volumeDown()
    {
        volume--;
    }
}
