package com.example.javagui;
import javax.swing.*;
import java.awt.*;
import java.awt.Font;

public class MainForm extends JFrame
{
    private Font font_title = new Font(Font.SANS_SERIF, Font.BOLD, 24);
    //Header
    private JPanel panel_north = new JPanel();
    private JLabel lbl_register = new JLabel("Registration Form");
    //Footer
    private JPanel panel_south = new JPanel();
    private JButton btn_south = new JButton();
    void init_component()
    {
        setLayout(new BorderLayout());
        //Header
        panel_north.setLayout(new FlowLayout());
        panel_north.add(lbl_register);
        add(panel_north, BorderLayout.NORTH);
        //Content

        //Footer

        //Layouting
        setTitle("Registration Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public MainForm()
    {
        init_component();
    }
    public static void main(String[] args)
    {
        new MainForm();
    }
}
