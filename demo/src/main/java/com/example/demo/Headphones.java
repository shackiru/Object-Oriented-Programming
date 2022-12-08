package com.example.demo;

public class Headphones
{
    String charge = "Micro USB";
    String[] controls = {"Power", "Volume", "Skip", "Play/Pause"};
    String color = "Red/Black";
    static int volume = 0;
    static boolean power = false;
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
