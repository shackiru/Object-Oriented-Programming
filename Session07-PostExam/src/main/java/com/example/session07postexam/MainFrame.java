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
        setLayout(new BorderLayout());
        add(new JPanel());

        upperPanel = new JPanel();
        upperPanel.setBackground(Color.CYAN);
        add(upperPanel, "North");

        downPanel = new JPanel();
        downPanel.setBackground(Color.green);
        add(downPanel, "South");

        leftPanel = new JPanel();
        leftPanel.setBackground(Color.yellow);
        add(leftPanel, BorderLayout.WEST);

        rightPanel = new JPanel();
        rightPanel.setBackground(Color.red);
        add(rightPanel, BorderLayout.EAST);

        centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout());
        centerPanel.add(new JButton("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa"));
        centerPanel.add(new JButton("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa"));
        centerPanel.add(new JButton("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa"));
        centerPanel.add(new JButton("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa"));
        centerPanel.add(new JButton("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa"));
        centerPanel.add(new JButton("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa"));
        centerPanel.setBackground(Color.black);
        add(centerPanel, BorderLayout.CENTER);

        JButton btn1 = new JButton("Hello World");
        btn1.setPreferredSize(new Dimension(150, 50));
        upperPanel.add(btn1);
    }
    public MainFrame(Main main)
    {
        initComponent();
        this.main = main;
        setSize(600, 600);
        setTitle("Main Frame");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
