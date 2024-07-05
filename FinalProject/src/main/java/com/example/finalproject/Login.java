package com.example.finalproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

import org.w3c.dom.Text;
import org.w3c.dom.events.MouseEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;

public class Login extends JFrame implements ActionListener {
    private Font font_title = new Font(Font.DIALOG, Font.BOLD, 25);
    private Font font_desc = new Font(Font.DIALOG, Font.PLAIN, 30);

    private User user = new User();
//    private ArrayList<User> users = new ArrayList<>();

    //    Header
    private JButton btn_regist = new JButton("REGISTER");
    private JPanel panel_north = new JPanel();
    private JLabel label_login = new JLabel("WELCOME");
    private JLabel label_empty = new JLabel("              ");

    //    Component
    private JPanel panel_center = new JPanel();
    private JTextField text_email = new JTextField();
    private JPasswordField text_password = new JPasswordField();

    //    Footer
    private JPanel panel_south = new JPanel();
    private JButton btn_submit = new JButton("SUBMIT");
    private JButton btn_clear = new JButton("CLEAR");

    private ArrayList<User> customerData = new ArrayList<>();
    private ArrayList<Admin> admins = new ArrayList<>();

    public void loadAdminData() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/dummyAdmin.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length == 2) {
                    String username = tokens[0];
                    String password = tokens[1];
                    Admin admin = new Admin(username, password);
                    admins.add(admin);
                } else {
                    System.out.println("Invalid data: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading customer data: " + e.getMessage());
        }
    }



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

    void  init_components(){
        setLayout(new BorderLayout());

//  Header
        panel_north.setLayout(new FlowLayout());
        panel_north.setBorder(BorderFactory.createEmptyBorder(100, 250, 10, 5));
        label_login.setFont(font_title);
        panel_north.add(label_login, "North");
        label_login.setHorizontalAlignment(JLabel.CENTER);
        label_empty.setFont(font_title);
        panel_north.add(label_empty, "North");
        btn_regist.setPreferredSize(new Dimension(100, 30));
        btn_regist.addActionListener(this);
        panel_north.add(btn_regist);
        add(panel_north, "North");

//  Content
        panel_center.setLayout(new GridLayout(3, 2));
        panel_center.setBorder(BorderFactory.createEmptyBorder(60, 210, 0, 210));
        // panel_center.setLayout(new GridLayout(1,5));

//  Row 1
        panel_center.add(new JLabel("Username"));
        panel_center.add(text_email);
        panel_center.setFont(font_desc);
        add(panel_center, "Center");

//  Row 2
        panel_center.add(new JLabel("Password"));
        panel_center.add(text_password);
        add(panel_center, "Center");

//  Footer
        panel_south.setLayout(new FlowLayout());
        panel_south.setBorder(BorderFactory.createEmptyBorder(50, 30, 100, 30));
        btn_clear.setPreferredSize(new Dimension(140, 30));
        btn_clear.addActionListener(this);
        btn_submit.addActionListener(this);
        btn_submit.setPreferredSize(new Dimension(140, 30));
        panel_south.add(btn_clear);
        panel_south.add(btn_submit);
        add(panel_south, "South");

        setTitle("Login Page");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(720, 512);
        setLocationRelativeTo(null);
        loadCusData();
        loadAdminData();
        setVisible(true);
    }

    public Login(){
        init_components();
    }

    public static void main(String[] args) {
        new Login();
    }

    public  void actionPerformed(ActionEvent e){
        Object obj = e.getSource();

        if(obj.equals(btn_submit)){
            String username = text_email.getText();
            String password = new String(text_password.getPassword());

            for (User user : customerData) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    CusHome cusHome = new CusHome(username, customerData);
                    cusHome.setVisible(true);
                    this.dispose();
                    return;
                }else {
//                	JOptionPane.showMessageDialog(this, "please input the correct username and or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            for(Admin admin: admins) {
                if(admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                    AdminHome adminHome = new AdminHome(username);
                    adminHome.setVisible(true);
                    this.dispose();
                    return;
                }
            }


//            if (!username.isEmpty() && !password.isEmpty()) {
//                CusHome cusHome = new CusHome();
//                cusHome.setVisible(true);
//                this.dispose();
//            } else {
//                JOptionPane.showMessageDialog(this, "please fill in both fields", "Error", JOptionPane.ERROR_MESSAGE);
//            }
        }

        if(obj.equals(btn_regist)){
            Register regist = new Register();
            regist.setVisible(true);
            this.dispose();
        }

        if(obj.equals(btn_clear)){
            text_email.setText("");
            text_password.setText("");
        }
    }
}