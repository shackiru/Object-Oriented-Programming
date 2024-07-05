package com.example.finalproject;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CusHome extends JFrame implements ActionListener{
    private  ArrayList<myGameData> myGames = new ArrayList<>();
    private String nameA;
    private String publisherA;
    private String genreA;
    private String idA;
    private int quanA;
    private int priceA;
    private String usernameA;
    private String pwA;
    private String statusA;
    private double balA;
    private int totNum = 50000;
    private ArrayList<Game> games = new ArrayList<>();
    private ArrayList<cartData> carts = new ArrayList<>();
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
    private JPanel homeTop = new JPanel();
    private JPanel homeLeft = new JPanel();
    private JPanel homeRight = new JPanel();
    private JPanel homeBottom = new JPanel();
    private JPanel homeCenter = new JPanel();
    private JPanel adminImgJPanel = new JPanel();
    private JPanel adminImgTop = new JPanel();
    private JPanel adminImgBottomJPanel = new JPanel();
    private JPanel adminImgCenterJPanel = new JPanel();
    private ImageIcon userImg = new ImageIcon("src/assets/user.jpg");
    private Image image = userImg.getImage();
    private Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    private ImageIcon scaledUserImg = new ImageIcon(scaledImage);
    private JLabel imgLabel = new JLabel(scaledUserImg);
    private JPanel adminInfoJPanel = new JPanel();
    private JPanel adminInfoTopPanel = new JPanel();
    private JPanel adminInfoDownJPanel = new JPanel();
    private JPanel adminInfoCenterJPanel = new JPanel();
    private JLabel usernameLabel = new JLabel("Username : ");
    private JLabel usernameValueLabel;
    private JLabel statusLabel = new JLabel("Status : ");
    private JLabel statusValueLabel;
    private JLabel balanceLabel = new JLabel("Balance : ");
    private JLabel balanceValueLabel;
    private JPanel adminButtonsJPanel = new JPanel();
    private JButton logOutButton = new JButton("Log Out");
    private JButton upgradeButton = new JButton("Upgrade Member");


    private ArrayList<User> customerData = new ArrayList<>();
    private String status = "";
    private String balance = "";


    public void initComp(String username) {
        //read file
        try (BufferedReader br = new BufferedReader(new FileReader("src/dummyCus.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens[0].equals(username)) {
                    status = tokens[2];
                    balance = tokens[3];
                    int bal = Integer.parseInt(balance);
                    break;
                }
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Error loading customer data: " + e.getMessage());
        }
        setLayout(new BorderLayout());
        westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
//		westPanel.setBackground(Color.cyan);

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
        myGameButton.addActionListener(this);
        buyGameButton.setFont(new Font(getName(), ABORT, 15));
        navLinksPanel.add(buyGameButton);
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

        //EASTTTT
        eastPanel.setLayout(new BorderLayout());
        homeTop.setPreferredSize(new Dimension(WIDTH, 50));
        homeBottom.setPreferredSize(new Dimension(WIDTH, 50));
        homeLeft.setPreferredSize(new Dimension(80, HEIGHT));
        homeRight.setPreferredSize(new Dimension(80, HEIGHT));
        eastPanel.add(homeTop, "North");
        eastPanel.add(homeRight, "East");
        eastPanel.add(homeBottom, "South");
        eastPanel.add(homeLeft, "West");

        homeCenter.setLayout(new GridLayout(1, 2));
        //IMG
        adminImgJPanel.setLayout(new FlowLayout());
        adminImgTop.setPreferredSize(new Dimension(WIDTH, 150));
        adminImgJPanel.add(adminImgTop, "North");
        adminImgBottomJPanel.setPreferredSize(new Dimension(WIDTH, 150));
        adminImgJPanel.add(adminImgBottomJPanel, "South");
        imgLabel.setPreferredSize(new Dimension(100, 300));
        adminImgCenterJPanel.add(imgLabel);
        adminImgJPanel.add(adminImgCenterJPanel, "Center");

        //INFO
        adminInfoJPanel.setLayout(new BorderLayout());
        adminInfoTopPanel.setPreferredSize(new Dimension(WIDTH, 150));
        adminInfoJPanel.add(adminInfoTopPanel, "North");
        adminInfoDownJPanel.setPreferredSize(new Dimension(WIDTH, 200));
        adminInfoJPanel.add(adminInfoDownJPanel, "South");
        adminInfoCenterJPanel.setLayout(new GridLayout(4,1));
        usernameValueLabel = new JLabel(username);
        statusValueLabel = new JLabel(status);
        balanceValueLabel = new JLabel(balance);
        adminInfoCenterJPanel.add(usernameLabel);
        adminInfoCenterJPanel.add(usernameValueLabel);
        adminInfoCenterJPanel.add(statusLabel);
        adminInfoCenterJPanel.add(statusValueLabel);
        adminInfoCenterJPanel.add(balanceLabel);
        adminInfoCenterJPanel.add(balanceValueLabel);
        logOutButton.setPreferredSize(new Dimension(40,30));
        logOutButton.addActionListener(this);
        upgradeButton.addActionListener(this);
        upgradeButton.setPreferredSize(new Dimension(40, 30));
        adminButtonsJPanel.setLayout(new GridLayout(2, 0, 0, 15));
//		logOutButton.setFont(getFont());
        adminButtonsJPanel.add(logOutButton);
        adminButtonsJPanel.add(upgradeButton);


        adminInfoCenterJPanel.add(adminButtonsJPanel);
        adminInfoJPanel.add(adminInfoCenterJPanel, "Center");

        homeCenter.add(adminImgJPanel);
        homeCenter.add(adminInfoJPanel);

        homeCenter.setBackground(Color.black);
        eastPanel.add(homeCenter, "Center");


        eastPanel.setBackground(Color.BLUE);
        eastPanel.setPreferredSize(new Dimension(620, HEIGHT));
        add(eastPanel, "East");
    }

    public void delFile(String username) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/dummyCus.txt"));


            for (int i = 0; i < lines.size(); i++) {
                String[] tokens = lines.get(i).split(",");
                if (tokens[0].equals(usernameValueLabel.getText())) {
                    lines.remove(i);
                    break;
                }
            }


            Files.write(Paths.get("src/dummyCus.txt"), lines);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public CusHome(String username, ArrayList<User> customerData) {
        this.customerData = customerData;
        initComp(username);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource().equals(logOutButton)) {
            int answer = JOptionPane.showConfirmDialog(null, "Are You Sure?", "Log Out", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (answer == JOptionPane.YES_OPTION) {
                Login login = new Login();
                login.setVisible(true);
                this.dispose();
                return;
            }
        }
        if (e.getSource().equals(myGameButton)) {
            myGame mygame = new myGame(myGames);
            mygame.setVisible(true);
            this.dispose();
        }

        if (e.getSource().equals(buyGameButton)) {
            buyGame buygame = new buyGame(usernameValueLabel.getText(), customerData);
            buygame.setVisible(true);
            this.dispose();
        }

        if (e.getSource().equals(cartButton)) {
            Cart cart = new Cart(carts, usernameValueLabel.getText(), games, customerData);
            cart.setVisible(true);
            this.dispose();
        }

        if (e.getSource().equals(upgradeButton)) {
            int answer = JOptionPane.showConfirmDialog(null, "Are You Sure You Want to Upgrade?", "Upgrade Member", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            int indexCus = 0;
            for (User i : customerData) {

                if (i.getUsername().equals(usernameValueLabel.getText())) {
                    usernameA = i.getUsername();
                    statusA = i.getMember();
                    balA = i.getBalance();
                    pwA = i.getPassword();
                } else {
                    indexCus += 1;
                }
            }

            delFile(usernameValueLabel.getText());
            balA = balA - totNum;
            statusA = "Member";
            int balAInt = (int) Math.round(balA);
            try {
                FileWriter writer = new FileWriter("src/dummyCus.txt", true);
                writer.write( usernameA + "," + pwA + "," + statusA + "," + balAInt +"\n");

                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: Could not write to file.");
            }
            customerData.remove(indexCus);
            customerData.add(new User(usernameA, pwA, statusA, balAInt));

        }
    }

}