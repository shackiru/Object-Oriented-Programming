package com.example.finalproject;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.border.Border;
import org.w3c.dom.Text;
import org.w3c.dom.events.MouseEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Payment extends JFrame implements ActionListener{

    private ArrayList<myGameData>myGames = new ArrayList<>();
    private ArrayList<Game>games = new ArrayList<>();
    private Font fontTitle = new Font(Font.DIALOG, Font.BOLD, 20);
    private double balLeft;
    private int quanLeft;
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
    private ArrayList<cartData> carts = new ArrayList<>();
    private JPanel eastPanel = new JPanel();
    private JPanel homeTop = new JPanel();
    private JPanel homeLeft = new JPanel();
    private JPanel homeRight = new JPanel();
    private JPanel homeBottom = new JPanel();
    private JPanel homeCenter = new JPanel();
    private JPanel adminInfoJPanel = new JPanel();
    private JPanel adminInfoTopJPanel = new JPanel();
    private JLabel paymentLabel = new JLabel("Invoice");
    private JPanel adminInfoDownJPanel = new JPanel();
    private JButton cancelButton = new JButton("Cancel");
    private JButton paymentButton = new JButton("Payment");
    private JPanel adminInfoCenterJPanel = new JPanel();

    private JLabel nameLabel = new JLabel("Game name : ");
    private JLabel nameValJLabel;
    private JLabel priceVaLabel;
    private JLabel publisherVaLabel;
    private JLabel taxVaLabel;
    private JLabel totVaLabel;
    private double taxNum;
    private double totNum;
    private JLabel publisherLabel = new JLabel("Publisher name : ");
    private JLabel priceLabel = new JLabel("Price  :  ");
    private JLabel quantityLabel = new JLabel();
    private JLabel taxLabel = new JLabel("Total Tax  : ");
    private JLabel totalLabel = new JLabel("Total Price : ");

    private JLabel usernameVal;

    private ArrayList<User> customerData = new ArrayList<>();

    public void loadCusData() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/dummyCus.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length == 4) {
                    String username = tokens[0];
                    String password = tokens[1];
                    String status = tokens[2];
                    String balanceString = tokens[3];
                    int bal = Integer.parseInt(balanceString);
                    User user = new User(username, password, status, bal);
                    customerData.add(user);
                } else {
                    System.out.println("Invalid data: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading customer data: " + e.getMessage());
        }
    }

    public Payment(String gameName, int gamePrice, String gamePublisher, String username,ArrayList<Game>games , ArrayList<User> cus) {
        this.games = games;
        // TODO Auto-generated method stub
        usernameVal = new JLabel(username);
        setLayout(new BorderLayout());

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

        //INFO
        adminInfoJPanel.setLayout(new BorderLayout());
        adminInfoTopJPanel.setPreferredSize(new Dimension(WIDTH, 150));
        adminInfoTopJPanel.setBorder(BorderFactory.createEmptyBorder(75, 0, 0, 30));
        adminInfoJPanel.add(adminInfoTopJPanel, "North");
        paymentLabel.setFont(fontTitle);
        adminInfoTopJPanel.add(paymentLabel);
        adminInfoJPanel.add(adminInfoCenterJPanel, "Center");
        adminInfoCenterJPanel.setLayout(new GridLayout(6,2));
        adminInfoCenterJPanel.setBorder(BorderFactory.createEmptyBorder(0, 118, 0, 0));
        adminInfoJPanel.add(adminInfoDownJPanel, "South");
        adminInfoDownJPanel.setPreferredSize(new Dimension(WIDTH, 200));
        cancelButton.setPreferredSize(new Dimension(100,30));
        cancelButton.addActionListener(this);
        paymentButton.setPreferredSize(new Dimension(100,30));
        paymentButton.addActionListener(this);
        adminInfoDownJPanel.add(cancelButton);
        adminInfoDownJPanel.add(paymentButton);
        adminInfoDownJPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));

        homeCenter.add(adminInfoJPanel);

        homeCenter.setBackground(Color.black);
        eastPanel.add(homeCenter, "Center");
        nameValJLabel = new JLabel(gameName);
        publisherVaLabel = new JLabel(gamePublisher);
        String gamePriceString = String.valueOf(gamePrice);
        priceVaLabel = new JLabel(gamePriceString);
        adminInfoCenterJPanel.add(nameLabel);
        adminInfoCenterJPanel.add(nameValJLabel);
        adminInfoCenterJPanel.add(publisherLabel);
        adminInfoCenterJPanel.add(publisherVaLabel);
        adminInfoCenterJPanel.add(priceLabel);
        adminInfoCenterJPanel.add(priceVaLabel);
        taxNum = gamePrice*0.05;
        String gameTaxStr = String.valueOf(taxNum);
        taxVaLabel = new JLabel(gameTaxStr);

        totNum = gamePrice + taxNum;
        String totStr = String.valueOf(totNum);
        totVaLabel = new JLabel(totStr);

        adminInfoCenterJPanel.add(taxLabel);
        adminInfoCenterJPanel.add(taxVaLabel);
        adminInfoCenterJPanel.add(totalLabel);
        adminInfoCenterJPanel.add(totVaLabel);

        eastPanel.setBackground(Color.BLUE);
        eastPanel.setPreferredSize(new Dimension(620, HEIGHT));
        add(eastPanel, "East");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        loadCusData();
    }

    public void delFile(String gameName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/dummyGame.txt"));


            for (int i = 0; i < lines.size(); i++) {
                String[] tokens = lines.get(i).split(",");
                if (tokens[1].equals(nameValJLabel.getText())) {
                    lines.remove(i);
                    break;
                }
            }


            Files.write(Paths.get("src/dummyGame.txt"), lines);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void delFileCus(String usernameString) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/dummyCus.txt"));


            for (int i = 0; i < lines.size(); i++) {
                String[] tokens = lines.get(i).split(",");
                if (tokens[0].equals(usernameVal.getText())) {
                    lines.remove(i);
                    break;
                }
            }


            Files.write(Paths.get("src/dummyCus.txt"), lines);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource().equals(paymentButton)) {
            int response = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(response == JOptionPane.YES_OPTION){

                int index = 0;
                for(Game i : games) {

                    if(i.getGameName().equals(nameValJLabel.getText())) {

                        idA = i.getId();
                        nameA = i.getGameName();
                        genreA = i.getGenre();
                        quanA = i.getQuan();
                        priceA = i.getGamePrice();
                        publisherA = i.getPublisher();
                    }else {
                        index +=1;
                    }
                }

                int indexCus = 0;
                for(User i : customerData) {

                    if(i.getUsername().equals(usernameVal.getText())) {
                        usernameA = i.getUsername();
                        statusA = i.getMember();
                        balA = i.getBalance();
                        pwA = i.getPassword();
                    }else {
                        indexCus +=1;
                    }
                }

                delFile(nameValJLabel.getText());
                delFileCus(usernameVal.getText());

                try {
                    FileWriter writer = new FileWriter("src/dummyGame.txt", true);
                    writer.write( idA + "," + nameA +","+ genreA +"," + (quanA-1) +","+ priceA + "," + publisherA +  "\n");

                    writer.close();


                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: Could not write to file.");
                }
                balA = balA - totNum;
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
                games.remove(index);
                games.add(new Game(idA, nameA, genreA, quanA-1, priceA, publisherA));
                JOptionPane.showMessageDialog(null, "Your payment was successful!", "Payment Success", JOptionPane.NO_OPTION);
                Cart cart = new Cart(carts, usernameVal.getText(), games, customerData);
                cart.setVisible(true);
                this.dispose();

            } else if(response == JOptionPane.NO_OPTION){

                JOptionPane.showMessageDialog(null, "Sorry, we couldn't process your payment", "Payment Unsuccess", JOptionPane.NO_OPTION);
                Cart cart = new Cart(carts, usernameVal.getText(), games, customerData);
                cart.setVisible(true);
                this.dispose();
                return;

            } else if(response == JOptionPane.OK_CANCEL_OPTION){

                JOptionPane.showMessageDialog(null, "", "Cancel", JOptionPane.OK_CANCEL_OPTION);
                Cart cart = new Cart(carts, usernameVal.getText(), games, customerData);
                cart.setVisible(true);
                this.dispose();
                return;
            }
        } else if(e.getSource().equals(cancelButton)){
            Cart cart = new Cart(carts, usernameVal.getText(),games, customerData);
            cart.setVisible(true);
            this.dispose();
            return;
        }
    }

}


