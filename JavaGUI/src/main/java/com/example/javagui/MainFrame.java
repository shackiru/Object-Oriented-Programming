package com.example.javagui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;

public class MainFrame extends JFrame implements ActionListener
{
    JButton b1;
    JPanel newPanel;
    JLabel userLabel, passLabel;
    final JTextField textField1, textField2;

    public MainFrame()
    {
        userLabel = new JLabel();
        userLabel.setText("Username");

        textField1 = new JTextField(15);
        textField1.setBounds(100, 27, 193, 28);

        passLabel = new JLabel();
        passLabel.setText("Password");

        textField2 = new JPasswordField(15);
        textField2.setBounds(155, 50, 193, 28);

        b1 = new JButton("SUBMIT");
        newPanel = new JPanel(new GridLayout(3, 1));
        newPanel.add(userLabel);
        newPanel.add(textField1);
        newPanel.add(passLabel);
        newPanel.add(textField2);
        newPanel.add(b1);

        add(newPanel, BorderLayout.CENTER);
        b1.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String userValue = textField1.getText();
        String passValue = textField2.getText();

        if(userValue.equals("Shaquille") && passValue.equals("123456"))
        {
            Homepage page = new Homepage();
            page.setVisible(true);
            JLabel welcomeLabel = new JLabel("Welcome " + userValue);
            page.getContentPane().add(welcomeLabel);
        }
        else
        {
            System.out.println("Wrong username or password!");
        }
    }
}

class LoginDemo
{
    public static void main(String args[])
    {
        try
        {
            MainFrame form = new MainFrame();
            form.setSize(500, 500);
            form.setVisible(true);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
