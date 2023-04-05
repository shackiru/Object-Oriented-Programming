package com.example.finalproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame implements ActionListener {
    private Font font_title = new Font(Font.SERIF, Font.BOLD, 20);

//    Header
    private JPanel panel_north = new JPanel();
    private JLabel label_register = new JLabel("WELCOME");

//    Component
    private JPanel panel_center = new JPanel();
    private JTextField text_username = new JTextField();
    private JTextField text_email = new JTextField();
    private JTextArea text_address = new JTextArea();
    private JRadioButton radio_male = new JRadioButton("Male");
    private  JRadioButton radio_female = new JRadioButton("Female");

//    Footer
    private JPanel panel_south = new JPanel();
    private JButton btn_submit = new JButton("SUBMIT");
    private JButton btn_clear = new JButton("CLEAR");

    void init_components(){
        setLayout(new BorderLayout());

//        Header
        panel_north.setLayout(new FlowLayout());
        label_register.setFont(font_title);
        panel_north.add(label_register);
        add(panel_north, BorderLayout.NORTH);

//        Content
        panel_center.setLayout(new GridLayout(6, 2));

//        Row 1
        panel_center.add(new JLabel("Username"));
        panel_center.add(text_username);

//        Row 2
        panel_center.add(new JLabel("Email"));
        panel_center.add(text_email);

//        Row 3
        panel_center.add(new JLabel("Address"));
        panel_center.add(text_address);

//        Row 4
        panel_center.add(new JLabel("Gender"));
        JPanel panel_gender = new JPanel();
        panel_gender.setLayout(new GridLayout(2, 1));

        ButtonGroup bg_gender = new ButtonGroup();
        bg_gender.add(radio_male);
        bg_gender.add(radio_female);

        panel_gender.add(radio_male);
        panel_gender.add(radio_female);
        panel_center.add(panel_gender);

//        Footer
        panel_south.setLayout(new FlowLayout());
        btn_submit.addActionListener(this);
        panel_south.add(btn_submit);

        btn_clear.addActionListener(this);
        panel_south.add(btn_clear);
        add(panel_south, "South");

        setTitle("Register Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 800);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public Register(){
        init_components();
    }

    public static void main(String[] args) {
        new Register();
    }

    public void actionPerformed(ActionEvent e){
        Object obj = e.getSource();
        String username = text_username.getText();
        String email = text_email.getText();
        String address = text_address.getText();
        String gender = "";
        if(radio_male.isSelected()){
            gender = "Male";
        }  else if(radio_female.isSelected()){
            gender = "Female";
        }
    }
}
