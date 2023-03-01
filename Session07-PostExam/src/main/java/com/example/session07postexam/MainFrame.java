package com.example.session07postexam;
import java.awt.*;
import javax.swing.*;
public class MainFrame extends JFrame
{
    private Main main;
    private JPanel upperPanel;
    private JPanel downPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel centerPanel;
    public MainFrame()
    {

    }

    public void initComponent()
    {

    }
    public MainFrame(Main main)
    {
        this.main = main;
        setSize(600, 600);
        setTitle("Main Frame");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
