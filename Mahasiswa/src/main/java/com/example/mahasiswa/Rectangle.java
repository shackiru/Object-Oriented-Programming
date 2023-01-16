package com.example.mahasiswa;

import java.util.Scanner;

public class Rectangle
{

    private int width;
    private int height;
    private int area;
    private int around;
    public Rectangle()
    {

    }
    public Rectangle(int width, int height)
    {
        this.height = height;
        this.width = width;
        this.area = width * height;
        this.around = (2*width) + (2*height);
    }
    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getArea()
    {
        return height * width;
    }

    public int getAround()
    {
        return (2 * width) + (2 * height);
    }

    public boolean isSquare()
    {
        if(width == height)
        {
            return true;
        }
        return false;
    }

    public void print()
    {
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Area: " + area);
        System.out.println("Around: " + around);
    }

}
