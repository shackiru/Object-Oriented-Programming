package com.example.finalproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    private Font font_title = new Font(Font.SERIF, Font.BOLD, 20);
//    Header
    private JPanel panel_north = new JPanel();
    private  JLabel label_login = new JLabel("LOGIN");

//    Component
    private JPanel panel_center = new JPanel();
    private JTextField text_username = new JTextField();
    private JPasswordField text_password = new JPasswordField();

//    Footer
    private JPanel panel_south = new JPanel();
    private JButton btn_submit = new JButton("SUBMIT");
    private JButton btn_clear = new JButton("CLEAR");

    void  init_components(){
        setLayout(new BorderLayout());

//        Header
        panel_north.setLayout(new FlowLayout());
        label_login.setFont(font_title);
        panel_north.add(label_login);
        add(panel_north, BorderLayout.NORTH);

//        Content
        panel_center.setLayout(new GridLayout(3, 2));

//        Row 1
        panel_center.add(new JLabel("Username"));
        panel_center.add(text_username);
        add(panel_center, "Center");

//        Row 2
        panel_center.add(new JLabel("Password"));
        panel_center.add(text_password);
        add(panel_center, "Center");

//        Footer
        panel_south.setLayout(new FlowLayout());
        btn_submit.addActionListener(this);
        panel_south.add(btn_submit);

        btn_clear.addActionListener(this);
        panel_south.add(btn_clear);
        add(panel_south, "South");

        setTitle("Login Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 800);
        setLocationRelativeTo(null);
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
            String username = text_username.getText();
            String password = text_password.getText();
        }
    }
}