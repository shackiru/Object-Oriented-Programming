package com.example.finalproject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddGame extends JFrame implements ActionListener{
    private adminGameSide gameSide;

    private JPanel upPanel = new JPanel();
    private JLabel title = new JLabel("Add Game");
    private JPanel downPanel = new JPanel();
    private JButton backButton = new JButton("Back");
    private JButton submitButton = new JButton("Submit");
    private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
    private JLabel gameNameLabel = new JLabel("Game Name : ");
    private JLabel gameGenreLabel = new JLabel("Game genre : ");
    private JLabel gamePublisherlaLabel = new JLabel("Publisher : ");
    private JLabel gamePriceLabel = new JLabel("Price : ");
    private JLabel gameQuanLabel = new JLabel("Quantity : ");
    private JTextField gameNameTextField = new JTextField();
    private JTextField gameGenreTextField = new JTextField();
    private JTextField gamePublisherTextField = new JTextField();
    private JTextField gamePriceTextField = new JTextField();
    private JTextField gameQuanTextField = new JTextField();

    private JLabel usernameVal;

    public AddGame(String username) {

        setLayout(new BorderLayout());

        upPanel.setPreferredSize(new Dimension(WIDTH, 50));
        upPanel.setLayout(new FlowLayout());
        upPanel.add(title);
        downPanel.setPreferredSize(new Dimension(WIDTH, 50));
        leftPanel.setPreferredSize(new Dimension(100, HEIGHT));
        rightPanel.setPreferredSize(new Dimension(100, HEIGHT));
//
//		downPanel.setLayout(new FlowLayout());
        backButton.addActionListener(this);
        submitButton.addActionListener(this);
        downPanel.add(backButton);
        downPanel.add(submitButton);

        add(upPanel, "North");
        add(downPanel, "South");
        add(leftPanel, "West");
        add(rightPanel, "East");

        centerPanel.setLayout(new GridLayout(5, 2));
        centerPanel.add(gameNameLabel);
        centerPanel.add(gameNameTextField);
        centerPanel.add(gameGenreLabel);
        centerPanel.add(gameGenreTextField);
        centerPanel.add(gamePublisherlaLabel);
        centerPanel.add(gamePublisherTextField);
        centerPanel.add(gamePriceLabel);
        centerPanel.add(gamePriceTextField);
        centerPanel.add(gameQuanLabel);
        centerPanel.add(gameQuanTextField);

        add(centerPanel, "Center");

        usernameVal = new JLabel(username);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,500);
        setTitle("Add Game");
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource().equals(submitButton)) {
            String name = gameNameTextField.getText();
            String genre = gameGenreTextField.getText();
            String publisher = gamePublisherTextField.getText();
            String price = gamePriceTextField.getText();
            String quan = gameQuanTextField.getText();
            try {
                FileWriter writer = new FileWriter("src/dummyGame.txt", true);
                String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                Random random = new Random();
                char randomChar = alphabet.charAt(random.nextInt(alphabet.length()));
                int randomNum = random.nextInt(900) + 100;
                writer.write( randomChar + randomNum + "," + name +","+ genre +"," + quan+","+ price + "," + publisher +  "\n");

                writer.close();

                JOptionPane.showMessageDialog(null, "input successful!");

            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: Could not write to file.");
            }
            adminGameSide viewGamePage = new adminGameSide(usernameVal.getText());
            viewGamePage.setVisible(true);
            this.dispose();
        }

        if(e.getSource().equals(backButton)) {
            adminGameSide viewGamePage = new adminGameSide(usernameVal.getText());
            viewGamePage.setVisible(true);
            this.dispose();
            return;
        }
    }


}

