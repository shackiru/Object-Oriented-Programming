package com.example.javagui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaForm extends JFrame implements ActionListener
{
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuFile = new JMenu("File");
    private JMenuItem menuItemFileLogin = new JMenuItem("Login");
    private JMenuItem menuItemFile = new JMenuItem("Form 1");
    private JMenu menuOption = new JMenu("Option");
    private LoginForm loginForm;
    private JDesktopPane desktopPane = new JDesktopPane();

        public JavaForm()
        {
            add(desktopPane);
            menuBar.add(menuFile);
            menuFile.add(menuItemFileLogin);
            menuFile.add(new JSeparator());
            menuFile.add(menuItemFile);

            menuBar.add(menuOption);
            menuOption.setVisible(false);

            setJMenuBar(menuBar);
            menuItemFileLogin.addActionListener(this);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setExtendedState(MAXIMIZED_BOTH);
            setVisible(true);
        }
        public static void main (String[] args)
        {
            new JavaForm();
        }

        public void doLogin()
        {
            menuOption.setVisible(true);
        }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(menuItemFileLogin))
        {
//            JOptionPane.showMessageDialog(null, "Login");
//            desktopPane.add(loginForm);
//            loginForm.setVisible(true);
            if(loginForm == null || loginForm.isClosed())
            {
                loginForm = new LoginForm(this);
                desktopPane.add(loginForm);
            }
        }
    }
}
