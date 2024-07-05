package com.example.finalproject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateGame extends JFrame implements ActionListener{
    private JPanel upPanel = new JPanel();
    private JLabel title = new JLabel("Update Game : ");
    private JLabel titleValue;
    private JPanel downPanel = new JPanel();
    private JButton backButton = new JButton("Back");
    private JButton submitButton = new JButton("Update");
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

    public void delFile(String gameID) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/dummyGame.txt"));


            for (int i = 0; i < lines.size(); i++) {
                String[] tokens = lines.get(i).split(",");
                if (tokens[0].equals(gameID)) {
                    lines.remove(i);
                    break;
                }
            }


            Files.write(Paths.get("src/dummyGame.txt"), lines);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }


    public UpdateGame(String gameID, String username) {

        setLayout(new BorderLayout());

        upPanel.setPreferredSize(new Dimension(WIDTH, 50));
        upPanel.setLayout(new FlowLayout());
        upPanel.add(title);
        titleValue = new JLabel(gameID);
        upPanel.add(titleValue);
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
        usernameVal = new JLabel(username);
        add(centerPanel, "Center");


        setResizable(false);
        setSize(800,500);
        setTitle("Update Game");
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource().equals(submitButton)) {
            String name = gameNameTextField.getText();
            String genre = gameGenreTextField.getText();
            String quan = gameQuanTextField.getText();
            String price = gamePriceTextField.getText();
            String publisher = gamePublisherTextField.getText();
            delFile(titleValue.getText());
            try {
                FileWriter writer = new FileWriter("src/dummyGame.txt", true);
                writer.write( titleValue.getText() + "," + name +","+ genre +"," + quan+","+ price + "," + publisher +  "\n");

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
