package com.example.finalproject;

import javax.swing.*;
import java.awt.*;
import java.awt.*;

public class mainFrame extends JFrame {
    private JPanel westPanel = new JPanel();

    private JPanel navNorthPanel = new JPanel();
    private JLabel logoLabel = new JLabel("LOGO");

    private JPanel navSouthPanel = new JPanel();

    private JPanel navCenterPanel = new JPanel();

    private JPanel navCenterNorthJPanel = new JPanel();
    private JPanel navCenterEastJPanel = new JPanel();
    private JPanel navCenterWestJPanel = new JPanel();
    private JPanel navCenterSouthJPanel = new JPanel();
    private JPanel navLinksPanel = new JPanel();
    private JButton homeButton = new JButton("Home");
    private JButton myGameButton = new JButton("My Game");
    private JButton buyGameButton = new JButton("Buy Game");
    private JButton cartButton = new JButton("Cart");

    private JPanel eastPanel = new JPanel();

    public void initComp(){
        westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
//		westPanel.setBackground(Color.cyan);

        navNorthPanel.setLayout(new BoxLayout(navNorthPanel, BoxLayout.Y_AXIS));
        navNorthPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        navNorthPanel.add(Box.createVerticalGlue());
        navNorthPanel.setPreferredSize(new Dimension(WIDTH, 100));
        logoLabel.setFont(new Font(getName(), ABORT, 20));
        navNorthPanel.add(logoLabel);
        navNorthPanel.add(Box.createVerticalGlue());
        navNorthPanel.setBackground(Color.gray);
        westPanel.add(navNorthPanel);



        navCenterPanel.setLayout(new BorderLayout());
        navCenterNorthJPanel.setLayout(new FlowLayout());
        navCenterEastJPanel.setLayout(new FlowLayout());
        navCenterEastJPanel.setSize(new Dimension(200, WIDTH));
//		navCenterEastJPanel.setBackground(Color.red);
        navCenterWestJPanel.setLayout(new FlowLayout());
        navCenterSouthJPanel.setLayout(new FlowLayout());
        navCenterPanel.add(navCenterNorthJPanel, "North");
        navCenterPanel.add(navCenterEastJPanel, "East");
        navCenterPanel.add(navCenterSouthJPanel, "South");
        navCenterPanel.add(navCenterWestJPanel, "West");

//		navCenterPanel.setLayout(new BoxLayout(navCenterPanel, BoxLayout.Y));
        navLinksPanel.setLayout(new GridLayout(0, 1, 0, 10) );
        navLinksPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        homeButton.setFont(new Font(getName(), ABORT, 15));
//		homeButton.setSize(300, 300);
//		homeButton.setPreferredSize(new Dimension(navCenterPanel.getWidth()/2, navCenterPanel.getHeight()/2));
        navLinksPanel.add(homeButton);
        myGameButton.setFont(new Font(getName(), ABORT, 15));
        navLinksPanel.add(myGameButton);
        buyGameButton.setFont(new Font(getName(), ABORT, 15));
        navLinksPanel.add(buyGameButton);
        cartButton.setFont(new Font(getName(), ABORT, 15));
        navLinksPanel.add(cartButton);
        navLinksPanel.setPreferredSize(new Dimension(100, 500));
        navLinksPanel.setBackground(Color.GRAY);

        navCenterPanel.add(navLinksPanel, "Center");
        navCenterPanel.setBackground(Color.gray);
        westPanel.add(navCenterPanel);

        navSouthPanel.setLayout(new FlowLayout());
        navSouthPanel.setBackground(Color.gray);
        navSouthPanel.setPreferredSize(new Dimension(WIDTH, 100));
        westPanel.add(navSouthPanel);

        westPanel.setPreferredSize(new Dimension(267, HEIGHT));
        westPanel.setBackground(Color.gray);
        add(westPanel, "West");

        eastPanel.setLayout(new BorderLayout());

        eastPanel.setBackground(Color.BLUE);
        eastPanel.setPreferredSize(new Dimension(620, HEIGHT));
        add(eastPanel, "East");


    }

    public mainFrame(){
        initComp();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new mainFrame();
    }
}