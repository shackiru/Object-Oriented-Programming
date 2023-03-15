package com.example.javagui;
import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import java.util.Arrays;

public class MainForm extends JFrame implements ActionListener, WindowListener, MouseListener
{
    private Font font_title = new Font(Font.SANS_SERIF, Font.BOLD, 24);
    private Font font_btn = new Font(Font.SANS_SERIF, Font.PLAIN, 16);
    private Font font_lbl = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
    private Font radio_font = new Font(Font.SANS_SERIF, Font.BOLD, 14);

    //Header
    private JPanel panel_north = new JPanel();
    private JLabel lbl_register = new JLabel("Registration Form");


    //Content
    private JPanel panel_center = new JPanel();
    private JLabel lbl_username = new JLabel("Username");
    private JLabel lbl_password = new JLabel("Password");
    private JLabel lbl_name = new JLabel("Name");
    private JLabel lbl_address = new JLabel("Address");
    private JLabel lbl_gender = new JLabel("Gender");
    private JLabel lbl_hobby = new JLabel("Hobby");
    private JTextField txt_username = new JTextField();
    private JTextField txt_name = new JTextField();
    private JPasswordField txt_password = new JPasswordField();
    private JTextArea txt_address = new JTextArea();
    private JRadioButton radio_male = new JRadioButton("Male");
    private JRadioButton radio_female = new JRadioButton("Female");
    private JComboBox<String> combo_hobby = new JComboBox<>();

    //Footer
    private JPanel panel_south = new JPanel();
    private JButton btn_submit = new JButton("Submit");
    private JButton btn_clear = new JButton("Clear");
    void init_component()
    {
        setLayout(new BorderLayout());
        //Header
        panel_north.setLayout(new FlowLayout());
        panel_north.add(lbl_register);
        lbl_register.setFont(font_title);
        add(panel_north, BorderLayout.NORTH);

        //Content
        panel_center.setLayout(new GridLayout(6, 2));

        //Row 1
        panel_center.add(lbl_username);
        lbl_username.setFont(font_lbl);
        panel_center.add(txt_username);

        //Row 2
        panel_center.add(lbl_name);
        lbl_name.setFont(font_lbl);
        panel_center.add(txt_name);

        //Row 3
        panel_center.add(lbl_password);
        lbl_password.setFont(font_lbl);
        panel_center.add(txt_password);

        //Row 4
        panel_center.add(lbl_address);
        lbl_address.setFont(font_lbl);
        panel_center.add(txt_address);

        //Row 5
        panel_center.add(lbl_gender);
        lbl_gender.setFont(font_lbl);
        JPanel pnl_gender = new JPanel();
        ButtonGroup bg_Gender = new ButtonGroup();
        bg_Gender.add(radio_male);
        bg_Gender.add(radio_female);
        radio_male.setFont(radio_font);
        radio_female.setFont(radio_font);
        pnl_gender.setLayout(new GridLayout(2, 1));
        pnl_gender.add(radio_male);
        pnl_gender.add(radio_female);
        panel_center.add(pnl_gender);

        //Row 6
        panel_center.add(lbl_hobby);
        combo_hobby.addItem("Reading");
        combo_hobby.addItem("Writing");
        combo_hobby.addItem("Coding");
        panel_center.add(combo_hobby);

        add(panel_center);

        //Footer
        panel_south.setLayout(new FlowLayout());
        panel_south.add(btn_submit);
        btn_submit.addActionListener(this);

        panel_south.add(btn_clear);
        btn_clear.addActionListener(this);
        btn_clear.setFont(font_btn);
        btn_submit.setFont(font_btn);
        add(panel_south, "South");

        addWindowListener(this);
        addMouseListener(this);

        //Layouting
        setTitle("Registration Form");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
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

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object obj = e.getSource();
        String username = txt_username.getText();
        String name = txt_name.getText();
        String password = Arrays.toString(txt_password.getPassword());
        String address = txt_address.getText();
        String gender = "";

        if(radio_male.isSelected())
        {
            gender = "Male";
        }
        else if(radio_female.isSelected())
        {
            gender = "Female";
        }

        String hobby = combo_hobby.getSelectedItem().toString();

        if(username.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Username must be filled");
        }
        else if(name.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Name must be filled");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Data add successfully");
            System.exit(0);
        }

        if(obj.equals(btn_submit))
        {
            JOptionPane.showMessageDialog(null, "Hello World");
            JOptionPane.showMessageDialog(null,
                    "Hello" + username,
                    "Message",
                    JOptionPane.QUESTION_MESSAGE);
        }
        else if(obj.equals(btn_clear))
        {
            txt_username.setText("");
            radio_male.setSelected(false);
            radio_female.setSelected(false);
        }
    }

    @Override
    public void windowOpened(WindowEvent e)
    {
        JOptionPane.showMessageDialog(null, "Welcome");
    }

    @Override
    public void windowClosing(WindowEvent e)
    {
        int answer = JOptionPane.showConfirmDialog(null,
                "Are your sure to exit?",
                "Exit Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if(answer == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }

    @Override
    public void windowClosed(WindowEvent e)
    {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        System.out.println("Enter");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        System.out.println("Exit");
    }
}
