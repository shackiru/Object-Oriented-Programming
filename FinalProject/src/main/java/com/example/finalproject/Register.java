package com.example.finalproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import org.w3c.dom.Text;
import org.w3c.dom.events.MouseEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame implements ActionListener {
    private Font font_title = new Font(Font.DIALOG, Font.BOLD, 25);

    //    Header
    private JButton btn_login = new JButton("LOGIN");
    private JPanel panel_north = new JPanel();
    private JLabel label_register = new JLabel("WELCOME");
    private JLabel label_empty = new JLabel("              ");

    //    Component
    private JPanel panel_center = new JPanel();
    private JTextField text_username = new JTextField();
    private JTextField text_email = new JTextField();
    private JTextField text_pw = new JTextField();
    private JRadioButton radio_male = new JRadioButton("Male");
    private JRadioButton radio_female = new JRadioButton("Female");

    //    Footer
    private JPanel panel_south = new JPanel();
    private JButton btn_submit = new JButton("SUBMIT");
    private JButton btn_clear = new JButton("CLEAR");

    void init_components(){
        setLayout(new BorderLayout());

        //        Header
        panel_north.setLayout(new FlowLayout());
        panel_north.setBorder(BorderFactory.createEmptyBorder(100, 250, 10, 5));
        label_register.setFont(font_title);
        panel_north.add(label_register, "North");
        label_register.setHorizontalAlignment(JLabel.CENTER);
        label_empty.setFont(font_title);
        panel_north.add(label_empty, "North");
        btn_login.setPreferredSize(new Dimension(100, 30));
        btn_login.addActionListener(this);
        panel_north.add(btn_login);
        add(panel_north, "North");

        //        Content
        panel_center.setLayout(new GridLayout(6, 2));
        panel_center.setBorder(BorderFactory.createEmptyBorder(50, 210, 0, 210));

        //        Row 1
        panel_center.add(new JLabel("Username     "));
        panel_center.add(text_username);
        add(panel_center, "Center");

        //        Row 2
        panel_center.add(new JLabel("Email             "));
        panel_center.add(text_email);
        add(panel_center, "Center");

        //        Row 3
        panel_center.add(new JLabel("Set Password        "));
        panel_center.add(text_pw);
        add(panel_center, "Center");

        //        Row 4
        panel_center.add(new JLabel("Gender         "));
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
        panel_south.setBorder(BorderFactory.createEmptyBorder(0, 50, 100, 50));
        btn_clear.setPreferredSize(new Dimension(140, 30));
        btn_clear.addActionListener(this);
        btn_submit.addActionListener(this);
        btn_submit.setPreferredSize(new Dimension(140, 30));
        panel_south.add(btn_clear);
        panel_south.add(btn_submit);
        add(panel_south, "South");

        setResizable(false);
        setTitle("Register Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(720, 512);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public Register(){
        init_components();
    }

    public static void main(String[] args){
        new Register();
    }

    public void actionPerformed(ActionEvent e){
        Object obj = e.getSource();
//        String username = text_username.getText();
        String email = text_email.getText();
//        String address = text_pw.getText();
        String gender = "";
        if(radio_male.isSelected()){
            gender = "Male";
        }  else if(radio_female.isSelected()){
            gender = "Female";
        }

        if(obj.equals(btn_submit)){
            String username = text_username.getText();
            String password = text_pw.getText();

            try {
                FileWriter writer = new FileWriter("src/dummyCus.txt", true);
                int randomNum = (int) (Math.random() * 6) + 5;
                writer.write(username + "," + password + ",Non-Member," +  randomNum + "\n");

                writer.close();

                JOptionPane.showMessageDialog(null, "registration successful!");
                Login login = new Login();
                this.dispose();

            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: Could not write to file.");
            }
        }


        if(obj.equals(btn_login)){
            Login login = new Login();
            login.setVisible(true);
            this.dispose();
        }

        if(obj.equals(btn_clear)){
            text_pw.setText("");
            text_email.setText("");
            text_username.setText("");
            radio_male.setSelected(false);
            radio_female.setSelected(false);
        }
    }
}
