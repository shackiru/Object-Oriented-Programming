package com.example.javagui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JInternalFrame implements ActionListener
{
    private JButton btnLogin = new JButton("Login");
    private JavaForm javaForm;
    public LoginForm(JavaForm javaForm)
    {
        this.javaForm = javaForm;

        setLayout(new FlowLayout());
        add(btnLogin);
        btnLogin.addActionListener(this);

        setClosable(true);
        setSize(300, 400);
        setTitle("Login Form");
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(btnLogin))
        {
            javaForm.doLogin();
            dispose();
        }
    }
}
