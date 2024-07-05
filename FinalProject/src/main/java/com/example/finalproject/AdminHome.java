package com.example.finalproject;

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

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AdminHome extends JFrame implements ActionListener{

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
    private JButton viewGameButton = new JButton("View Game");

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
    private JLabel statusLabel = new JLabel("Status : Admin");
    private JButton logOutButton = new JButton("Log Out");

    public void initComp(String username) {
        // TODO Auto-generated method stub
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
//		navNorthPanel.setBackground(Color.gray);
        westPanel.add(navNorthPanel);



        navCenterPanel.setLayout(new BorderLayout());
        navCenterNorthJPanel.setLayout(new FlowLayout());
        navCenterEastJPanel.setLayout(new FlowLayout());
        navCenterEastJPanel.setSize(new Dimension(200, WIDTH));
//		navCenterEastJPanel.setBackground(Color.red);
        navCenterWestJPanel.setLayout(new FlowLayout());
        navCenterSouthJPanel.setLayout(new FlowLayout());
//		navCenterNorthJPanel.setBackground(Color.GRAY);
//		navCenterEastJPanel.setBackground(Color.GRAY);
//		navCenterSouthJPanel.setBackground(Color.GRAY);
//		navCenterWestJPanel.setBackground(Color.GRAY);
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
        viewGameButton.addActionListener(this);
        viewGameButton.setFont(new Font(getName(), ABORT, 15));
        navLinksPanel.add(viewGameButton);
        navLinksPanel.setPreferredSize(new Dimension(100, 500));
//		navLinksPanel.setBackground(Color.GRAY);

        navCenterPanel.add(navLinksPanel, "Center");
//		navCenterPanel.setBackground(Color.gray);
        westPanel.add(navCenterPanel);

        navSouthPanel.setLayout(new FlowLayout());
//		navSouthPanel.setBackground(Color.gray);
        navSouthPanel.setPreferredSize(new Dimension(WIDTH, 100));
        westPanel.add(navSouthPanel);


        westPanel.setPreferredSize(new Dimension(267, HEIGHT));
//		westPanel.setBackground(Color.gray);
        add(westPanel, "West");



        //EASTTTT

        eastPanel.setLayout(new BorderLayout());
        homeTop.setPreferredSize(new Dimension(WIDTH, 50));
        homeBottom.setPreferredSize(new Dimension(WIDTH, 50));
        homeLeft.setPreferredSize(new Dimension(80, HEIGHT));
        homeRight.setPreferredSize(new Dimension(80, HEIGHT));
//		homeTop.setBackground(Color.red);
//		homeBottom.setBackground(Color.red);
//		homeLeft.setBackground(Color.red);
//		homeRight.setBackground(Color.red);
        eastPanel.add(homeTop, "North");
        eastPanel.add(homeRight, "East");
        eastPanel.add(homeBottom, "South");
        eastPanel.add(homeLeft, "West");

        homeCenter.setLayout(new GridLayout(1, 2));
        //IMG
        adminImgJPanel.setLayout(new FlowLayout());
        adminImgTop.setPreferredSize(new Dimension(WIDTH, 150));
//		adminImgTop.setBackground(Color.red);
        adminImgJPanel.add(adminImgTop, "North");
        adminImgBottomJPanel.setPreferredSize(new Dimension(WIDTH, 150));
//		adminImgBottomJPanel.setBackground(Color.red);
        adminImgJPanel.add(adminImgBottomJPanel, "South");
//		adminImgJPanel.setBackground(Color.cyan);
        imgLabel.setPreferredSize(new Dimension(100, 300));
        adminImgCenterJPanel.add(imgLabel);
        adminImgJPanel.add(adminImgCenterJPanel, "Center");

        //INFO
        adminInfoJPanel.setLayout(new BorderLayout());
        adminInfoTopPanel.setPreferredSize(new Dimension(WIDTH, 150));
        adminInfoJPanel.add(adminInfoTopPanel, "North");
        adminInfoDownJPanel.setPreferredSize(new Dimension(WIDTH, 200));
        adminInfoJPanel.add(adminInfoDownJPanel, "South");
        adminInfoCenterJPanel.setLayout(new GridLayout(3,1));
//		adminInfoCenterJPanel.setBackground(Color.lightGray);
        usernameValueLabel = new JLabel(username);
        adminInfoCenterJPanel.add(usernameLabel);
        adminInfoCenterJPanel.add(usernameValueLabel);
        adminInfoCenterJPanel.add(statusLabel);
        logOutButton.setPreferredSize(new Dimension(40,40));
        logOutButton.addActionListener(this);
        adminInfoCenterJPanel.add(logOutButton);
        adminInfoJPanel.add(adminInfoCenterJPanel, "Center");

        homeCenter.add(adminImgJPanel);
        homeCenter.add(adminInfoJPanel);

        homeCenter.setBackground(Color.black);
        eastPanel.add(homeCenter, "Center");


        eastPanel.setBackground(Color.BLUE);
        eastPanel.setPreferredSize(new Dimension(620, HEIGHT));
        add(eastPanel, "East");
    }


    public AdminHome(String username) {
        initComp(username);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new AdminHome("tes");
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

        if(e.getSource().equals(viewGameButton)) {
            adminGameSide viewGamePage = new adminGameSide(usernameValueLabel.getText());
            viewGamePage.setVisible(true);
            this.dispose();
            return;
        }
    }

}
