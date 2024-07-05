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

public class Cart extends JFrame implements ActionListener
{
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

    private JButton deleteCartButton = new JButton("Delete");
    private JButton purchaseButton = new JButton("Purchase");
    private ArrayList<cartData>carts = new ArrayList<>();
    private ArrayList<Game>games = new ArrayList<>();
    private DefaultTableModel model;
    private JTable gameTable;
    public void loadTable() {
        String[] tableTitle = {"Name", "Price", "Publisher"};
        model = new DefaultTableModel(tableTitle, 0);

        for(cartData cart: carts) {
            String name = cart.getGameTitle();
            int price = cart.getGamePrice();
            String publisher = cart.getGamePublisher();
            System.out.println(cart.getGamePublisher());

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
        navCenterEastJPanel.setSize(new Dimension(200, WIDTH));
        navCenterWestJPanel.setLayout(new FlowLayout());
        navCenterSouthJPanel.setLayout(new FlowLayout());
        navCenterPanel.add(navCenterNorthJPanel, "North");
        navCenterPanel.add(navCenterEastJPanel, "East");
        navCenterPanel.add(navCenterSouthJPanel, "South");
        navCenterPanel.add(navCenterWestJPanel, "West");

        navLinksPanel.setLayout(new GridLayout(0, 1, 0, 10) );
        navLinksPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        homeButton.setFont(new Font(getName(), ABORT, 15));
        navLinksPanel.add(homeButton);
        myGameButton.setFont(new Font(getName(), ABORT, 15));
        myGameButton.addActionListener(this);
        navLinksPanel.add(myGameButton);
        buyGameButton.setFont(new Font(getName(), ABORT, 15));
        buyGameButton.addActionListener(this);
        navLinksPanel.add(buyGameButton);
        cartButton.setFont(new Font(getName(), ABORT, 15));
        cartButton.addActionListener(this);
        navLinksPanel.add(cartButton);
        navLinksPanel.setPreferredSize(new Dimension(100, 500));

        navCenterPanel.add(navLinksPanel, "Center");
        westPanel.add(navCenterPanel);

        navSouthPanel.setLayout(new FlowLayout());
        navSouthPanel.setPreferredSize(new Dimension(WIDTH, 100));
        westPanel.add(navSouthPanel);

        westPanel.setPreferredSize(new Dimension(267, HEIGHT));
        add(westPanel, "West");

        eastPanel.setLayout(new BorderLayout());

        eastPanel.setBackground(Color.BLUE);
        eastPanel.setPreferredSize(new Dimension(620, HEIGHT));
        add(eastPanel, "East");

        eastPanel.add(cartEast, "East");
        cartEast.setPreferredSize(new Dimension(50, HEIGHT));

        eastPanel.add(cartWest, "West");
        cartWest.setPreferredSize(new Dimension(50, HEIGHT));

        eastPanel.add(cartNorth, "North");
        cartNorth.setLayout(new BorderLayout());
        cartNorth.setBorder(BorderFactory.createEmptyBorder(50, 25, 8 , 50));
        cartNorth.add(deleteCartButton, "East");

        eastPanel.add(cartSouth, "South");
        cartSouth.setLayout(new BorderLayout());
        cartSouth.setBorder(BorderFactory.createEmptyBorder(8, 25, 12 , 50));
        cartSouth.add(purchaseButton, "East");
        purchaseButton.addActionListener(this);

        cartMid.setLayout(new BorderLayout());
        cartMid.add(scrollTable);
        eastPanel.add(cartMid, "Center");

        //Interactive button
        deleteCartButton.addActionListener(this);
        purchaseButton.addActionListener(this);
        homeButton.addActionListener(this);
    }

    public Cart(ArrayList <cartData> carts, String username, ArrayList<Game> games, ArrayList<User> cus)
    {

        this.carts = carts;
        this.games = games;
        initComp(username);
        loadTable();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    public static void main(String[] args)
    {
        ArrayList<cartData> cart = new ArrayList<>();
        ArrayList<Game> games = new ArrayList<>();
        ArrayList<User> customerData = new ArrayList<>();
        Cart carts = new Cart(cart, "tes", games, customerData);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(homeButton))
        {
            CusHome cusHome = new CusHome(usernameVal.getText(), customerData);
            cusHome.setVisible(true);
            this.dispose();
        }
        int selectedRows = gameTable.getSelectedRow();
        if(checkCart.isSelected()){
            if(e.getSource().equals(purchaseButton)){
                String gameName = (String) gameTable.getValueAt(selectedRows, 0);
                int gamePrice = (Integer) gameTable.getValueAt(selectedRows, 1);
                String gamePublisher = (String) gameTable.getValueAt(selectedRows, 2);
                Payment payment = new Payment( gameName,  gamePrice, gamePublisher, usernameVal.getText(), games, customerData);
                payment.setVisible(true);
                this.dispose();
            }
        }
        if(e.getSource().equals(deleteCartButton))
        {
            if(selectedRows == -1)
            {
                JOptionPane.showMessageDialog(null, "Please select data(s) to delete...", "No data",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure want to delete?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION)
                {
                    String gameName = (String) gameTable.getValueAt(selectedRows, 0);
                    model.removeRow(selectedRows);
                    carts.remove(selectedRows);
                    gameTable.invalidate();
                }
            }
        }
        if(e.getSource().equals(purchaseButton))
        {
            if(selectedRows == -1)
            {
                JOptionPane.showMessageDialog(null, "There is no item selected");
            }
            else
            {
                String gameName = (String) gameTable.getValueAt(selectedRows, 0);
                int gamePrice = (Integer) gameTable.getValueAt(selectedRows, 1);
                String gamePublisher = (String) gameTable.getValueAt(selectedRows, 2);
                Payment payment = new Payment(gameName, gamePrice, gamePublisher, usernameVal.getText(), games, customerData);
            }
        }

        if(e.getSource().equals(buyGameButton)) {
            buyGame seeGame = new buyGame(usernameVal.getText(), customerData);
            seeGame.setVisible(true);
            this.dispose();
            return;
        }
    }
}