package com.example.session07postexam;
import javax.swing.JFrame;

public class Main extends JFrame
{
    private MainFrame mainFrame;

    public String username = "Yudy";
    public Main()
    {
        mainFrame = new MainFrame(this);
        mainFrame.setVisible(true);
        System.out.println(username);
    }
    public static void main(String[] args)
    {
        new Main();
    }
}
