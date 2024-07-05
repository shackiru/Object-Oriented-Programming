package com.example.mysection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyGame extends JFrame implements ActionListener
{
    private JPanel mainPanel = new JPanel();
    private JPanel northPanel = new JPanel();
    private JPanel westPanel = new JPanel();
    private JPanel midPanel = new JPanel();
    private JPanel eastPanel = new JPanel();
    private JPanel southPanel = new JPanel();
    private JPanel northNorth = new JPanel();
    private JPanel northSouth = new JPanel();
    private String[][] gameData =
            {
                    {"A001", "Valorant", "4", "32000", "Riot Games"},
                    {"A002", "Dota 2", "3", "40000", "Valve"}
            };
    private String[] tableTitle = {"ID", "Name", "Quantity", "Price", "Publisher"};
    private JTable gameTable = new JTable(gameData, tableTitle);

    public void initComp()
    {
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.black);

        mainPanel.add(northPanel, "North");
        northPanel.setLayout(new BorderLayout());
        northPanel.add(northNorth, "North");
        northPanel.add(northSouth, "South");
        northNorth.setBackground(Color.red);
        northSouth.setBackground(Color.cyan);

        mainPanel.add(westPanel, "West");

        mainPanel.add(midPanel, "Center");


        mainPanel.add(eastPanel, "East");

        mainPanel.add(southPanel, "South");
        southPanel.setLayout(new CardLayout());
        southPanel.setPreferredSize(new Dimension(510, 510));
        southPanel.setBackground(Color.blue);

        midPanel.setLayout(new BoxLayout(midPanel, BoxLayout.Y_AXIS));
        midPanel.add(gameTable);
        gameTable.setBounds(30, 40, 200, 200);
    }

    public MyGame()
    {
        initComp();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new MyGame();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
}
