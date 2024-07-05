package com.example.finalproject;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class myGame extends JFrame implements ActionListener
{
    private ArrayList<myGameData> myGameData = new ArrayList<>();
    private ArrayList<Game> games = new ArrayList<>();
    private ArrayList<User> customerData = new ArrayList<>();
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

    private JPanel cartWest = new JPanel();
    private JPanel cartEast = new JPanel();
    private JPanel cartNorth = new JPanel();
    private JPanel cartSouth = new JPanel();
    private JPanel cartMid = new JPanel();

    private JPanel eastPanel = new JPanel();
    private JCheckBox checkCart = new JCheckBox();
    private JButton refundButton = new JButton("Refund");
    private ArrayList<myGameData>myGames = new ArrayList<>();
    private DefaultTableModel model;
    private JTable gameTable;

    public void loadTable() {
        String[] tableTitle = {"Name", "Price", "Publisher"};
        model = new DefaultTableModel(tableTitle, 0);

        for(myGameData mygame: myGames) {
            String name = mygame.getGameTitle();
            int price = mygame.getGamePrice();
            String publisher = mygame.getGamePublisher();
            System.out.println(mygame.getGamePublisher());

            Object[] row = {name, price, publisher};
            model.addRow(row);
        }

        gameTable.setModel(model);
    }

    private JScrollPane scrollTable ;
    private JLabel usernameVal;

    public void initComp(String username)
    {
        usernameVal = new JLabel(username);
        gameTable = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {

                return false;
            }

            public Class getColumnClass(int column) {
                switch(column)
                {
                    case 0 :
                        return String.class;
                    case 1 :
                        return String.class;
                    default :
                        return String.class;
                }
            }
        };
        scrollTable = new JScrollPane(gameTable);
        westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));

        navNorthPanel.setLayout(new BoxLayout(navNorthPanel, BoxLayout.Y_AXIS));
        navNorthPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        navNorthPanel.add(Box.createVerticalGlue());
        navNorthPanel.setPreferredSize(new Dimension(WIDTH, 100));
        logoLabel.setFont(new Font(getName(), ABORT, 20));
        navNorthPanel.add(logoLabel);
        navNorthPanel.add(Box.createVerticalGlue());
        westPanel.add(navNorthPanel);

        navCenterPanel.setLayout(new BorderLayout());
        navCenterNorthJPanel.setLayout(new FlowLayout());
        navCenterEastJPanel.setLayout(new FlowLayout());
        // navCenterEastJPanel.setSize(new Dimension(200, WIDTH));
        navCenterWestJPanel.setLayout(new FlowLayout());
        navCenterSouthJPanel.setLayout(new FlowLayout());
        navCenterPanel.add(navCenterNorthJPanel, "North");
        navCenterPanel.add(navCenterEastJPanel, "East");
        navCenterPanel.add(navCenterSouthJPanel, "South");
        navCenterPanel.add(navCenterWestJPanel, "West");

        navLinksPanel.setLayout(new GridLayout(0, 1, 0, 10) );
        navLinksPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        homeButton.setFont(new Font(getName(), ABORT, 15));
        myGameButton.setFont(new Font(getName(), ABORT, 15));
        navLinksPanel.add(homeButton);
        homeButton.addActionListener(this);
        navLinksPanel.add(myGameButton);
        buyGameButton.setFont(new Font(getName(), ABORT, 15));
        navLinksPanel.add(buyGameButton);
        buyGameButton.addActionListener(this);
        buyGameButton.addActionListener(this);
        cartButton.setFont(new Font(getName(), ABORT, 15));
        navLinksPanel.add(cartButton);
        cartButton.addActionListener(this);
        navLinksPanel.setPreferredSize(new Dimension(100, 500));

        navCenterPanel.add(navLinksPanel, "Center");
        westPanel.add(navCenterPanel);

        navSouthPanel.setLayout(new FlowLayout());
        navSouthPanel.setPreferredSize(new Dimension(WIDTH, 100));
        westPanel.add(navSouthPanel);

        westPanel.setPreferredSize(new Dimension(267, HEIGHT));
        add(westPanel, "West");

        eastPanel.setLayout(new BorderLayout());

        eastPanel.setPreferredSize(new Dimension(620, HEIGHT));
        add(eastPanel, "East");

        eastPanel.add(cartEast, "East");
        cartEast.setPreferredSize(new Dimension(50, HEIGHT));

        eastPanel.add(cartWest, "West");
        cartWest.setPreferredSize(new Dimension(50, HEIGHT));

        eastPanel.add(cartNorth, "North");
        cartNorth.setLayout(new BorderLayout());
        cartNorth.setBorder(BorderFactory.createEmptyBorder(50, 25, 8 , 50));

        eastPanel.add(cartSouth, "South");
        cartSouth.setLayout(new BorderLayout());
        cartSouth.setBorder(BorderFactory.createEmptyBorder(8, 25, 12 , 50));
        cartSouth.add(refundButton, "East");
        refundButton.addActionListener(this);

        cartMid.setLayout(new BorderLayout());
        cartMid.add(scrollTable);
        eastPanel.add(cartMid, "Center");
        JLabel labelmy = new JLabel("LABELLL");
        cartMid.add(labelmy);
    }

    public myGame(ArrayList<myGameData> myGames){
        this.myGames = myGames;
        initComp(getName());
        loadTable();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource().equals(buyGameButton)){
            buyGame buygame = new buyGame(usernameVal.getText(), customerData);
            buygame.setVisible(true);
            this.dispose();
        }

        if(e.getSource().equals(refundButton)){

            int response = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(response == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "Refund Success", "Refund", JOptionPane.NO_OPTION);
            } else if(response == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null, "Cancel", "", JOptionPane.NO_OPTION);
            } else if(response == JOptionPane.OK_CANCEL_OPTION){
                JOptionPane.showMessageDialog(null, "", "Cancel", JOptionPane.OK_CANCEL_OPTION);
            }
        }

        int selectedRows = gameTable.getSelectedRow();
        if(checkCart.isSelected()) {
            if (e.getSource().equals(refundButton)) {
                String gameName = (String) gameTable.getValueAt(selectedRows, 0);
                int gamePrice = (Integer) gameTable.getValueAt(selectedRows, 1);
                String gamePublisher = (String) gameTable.getValueAt(selectedRows, 2);
                Payment payment = new Payment(gameName, gamePrice, gamePublisher, usernameVal.getText(), games, customerData);
                payment.setVisible(true);
                this.dispose();
            }
        }
    }
}