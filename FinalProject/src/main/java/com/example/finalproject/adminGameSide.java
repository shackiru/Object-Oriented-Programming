package com.example.finalproject;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class adminGameSide extends JFrame implements ActionListener
{
    private ArrayList<Game>games = new ArrayList<>();

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

    private JPanel cartPanel = new JPanel();
    private JPanel cartWest = new JPanel();
    private JPanel cartEast = new JPanel();
    private JPanel cartNorth = new JPanel();
    private JPanel cartSouth = new JPanel();
    private JPanel cartMid = new JPanel();
    private JPanel northNorth = new JPanel();
    private JPanel northNorthEast = new JPanel();
    private JPanel northNorthMid = new JPanel();
    private JPanel northNorthWest = new JPanel();
    private JPanel northSouth = new JPanel();
    private JPanel northEast = new JPanel();
    private JPanel northWest = new JPanel();
    private JSlider priceSlider = new JSlider();


    private DefaultTableModel model;
    private JTable gameTable;
    private JLabel usernameValue;


    public void loadGameData() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/dummyGame.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length == 6) {
                    String id = tokens[0];
                    String name = tokens[1];
                    String genre = tokens[2];
                    String quanString = tokens[3];
                    int quan = Integer.parseInt(quanString);
                    String priceString = tokens[4];
                    int price = Integer.parseInt(priceString);
                    String publisher = tokens[5];
                    Game game = new Game(id, name, genre, quan, price, publisher);
                    games.add(game);
//                    System.out.println(game.getGameName());
                } else {
                    System.out.println("Invalid data: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading customer data: " + e.getMessage());
        }
    }

    private JLabel labelSearch = new JLabel("Search Game:");
    private JTextField tfGame = new JTextField();
    private JComboBox comboSort = new JComboBox();

    public void loadTable() {
        String[] tableTitle = {"ID", "Name", "Genre", "Quantity", "Price", "Publisher", "Select"};
        model = new DefaultTableModel(tableTitle, 0);

        for(Game game: games) {
            String id = game.getId();
            String name = game.getGameName();
            String genre = game.getGenre();
            int quan = game.getQuan();
            int price = game.getGamePrice();
            String publisher = game.getPublisher();

            Object[] row = {id, name, genre, quan, price, publisher};
            model.addRow(row);
        }

        gameTable.setModel(model);
    }

    private JScrollPane scrollTable ;
    private JPanel eastPanel = new JPanel();
    private JButton jbAddGame = new JButton("Add Game");
    private JButton jbUpdateGame = new JButton("Update Game");
    private JButton jbDeleteGame = new JButton("Delete Game");

    private JPanel southEast = new JPanel();
    private JPanel southMid = new JPanel();
    private JPanel southWest = new JPanel();

    public void initComp(String username)
    {
        gameTable = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {

                return column == 6;
            }

            public Class getColumnClass(int column) {
                switch(column) {
                    case 0 :
                        return String.class;
                    case 1 :
                        return String.class;
                    case 2:
                        return String.class;
                    case 3 :
                        return String.class;
                    case 4 :
                        return String.class;
                    case 5 :
                        return String.class;
                    default :
                        return Boolean.class;
                }
            }
        };
        scrollTable = new JScrollPane(gameTable);

        westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
//		westPanel.setBackground(Color.cyan);

        navNorthPanel.setLayout(new BoxLayout(navNorthPanel, BoxLayout.Y_AXIS));
        navNorthPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        navNorthPanel.add(Box.createVerticalGlue());
        navNorthPanel.setPreferredSize(new Dimension(WIDTH, 100));
        logoLabel.setFont(new Font(getName(), ABORT, 20));
        navNorthPanel.add(logoLabel);
        navNorthPanel.add(Box.createVerticalGlue());
        navNorthPanel.setBackground(Color.gray);
        westPanel.add(navNorthPanel);



        navCenterPanel.setLayout(new BorderLayout());
        navCenterNorthJPanel.setLayout(new FlowLayout());
        navCenterEastJPanel.setLayout(new FlowLayout());
        navCenterEastJPanel.setSize(new Dimension(200, WIDTH));
//		navCenterEastJPanel.setBackground(Color.red);
        navCenterWestJPanel.setLayout(new FlowLayout());
        navCenterSouthJPanel.setLayout(new FlowLayout());
        navCenterPanel.add(navCenterNorthJPanel, "North");
        navCenterPanel.add(navCenterEastJPanel, "East");
        navCenterPanel.add(navCenterSouthJPanel, "South");
        navCenterPanel.add(navCenterWestJPanel, "West");

//		navCenterPanel.setLayout(new BoxLayout(navCenterPanel, BoxLayout.Y));
        navLinksPanel.setLayout(new GridLayout(0, 1, 0, 10) );
        navLinksPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        homeButton.setFont(new Font(getName(), ABORT, 15));
        homeButton.addActionListener(this);
//		homeButton.setSize(300, 300);
//		homeButton.setPreferredSize(new Dimension(navCenterPanel.getWidth()/2, navCenterPanel.getHeight()/2));
        navLinksPanel.add(homeButton);
        viewGameButton.setFont(new Font(getName(), ABORT, 15));
        navLinksPanel.add(viewGameButton);
        navLinksPanel.setPreferredSize(new Dimension(100, 500));
//        navLinksPanel.setBackground(Color.GRAY);

        navCenterPanel.add(navLinksPanel, "Center");
//        navCenterPanel.setBackground(Color.gray);
        westPanel.add(navCenterPanel);

        navSouthPanel.setLayout(new FlowLayout());
//        navSouthPanel.setBackground(Color.gray);
        navSouthPanel.setPreferredSize(new Dimension(WIDTH, 100));
        westPanel.add(navSouthPanel);

        westPanel.setPreferredSize(new Dimension(267, HEIGHT));
//        westPanel.setBackground(Color.gray);
        add(westPanel, "West");

        eastPanel.setLayout(new BorderLayout());

        eastPanel.setBackground(Color.BLUE);
        eastPanel.setPreferredSize(new Dimension(620, HEIGHT));
        add(eastPanel, "East");

//        cartPanel.setLayout(new BorderLayout());
        eastPanel.add(cartEast, "East");
        cartEast.setPreferredSize(new Dimension(20, HEIGHT));

        eastPanel.add(cartWest, "West");
        cartWest.setPreferredSize(new Dimension(20, HEIGHT));

        eastPanel.add(cartNorth, "North");
        cartNorth.setLayout(new BorderLayout());
        cartNorth.setBorder(BorderFactory.createEmptyBorder(25, 25, 10 , 25));

        cartNorth.add(northNorth, "North");
        northNorth.setLayout(new BorderLayout());

        northNorth.add(northNorthEast, "East");
        northNorthEast.setLayout(new FlowLayout());
        northNorthEast.add(logoLabel);

        northNorth.add(northNorthMid, "Center");
        northNorthMid.setLayout(new FlowLayout());

        northNorth.add(northNorthWest, "West");
        northNorthWest.setLayout(new FlowLayout());

        cartNorth.add(northSouth, "South");
        northSouth.setLayout(new GridLayout(1, 0, 10, 0));
        northSouth.add(labelSearch);
        northSouth.add(tfGame);
        northSouth.add(priceSlider);
        northSouth.add(comboSort);

        cartNorth.add(northEast, "East");
        northEast.setLayout(new FlowLayout());

        cartNorth.add(northWest, "West");
        northWest.setLayout(new FlowLayout());

        eastPanel.add(cartSouth, "South");
        cartSouth.setLayout(new BorderLayout());
        cartSouth.setBorder(BorderFactory.createEmptyBorder(25, 25, 10 , 25));
        cartSouth.setPreferredSize(new Dimension(WIDTH, 100));
        cartSouth.add(southEast, "East");
        jbAddGame.addActionListener(this);
        southEast.add(jbAddGame);
        cartSouth.add(southMid, "Center");
        jbUpdateGame.addActionListener(this);
        southMid.add(jbUpdateGame);
        cartSouth.add(southWest, "West");
        southWest.add(jbDeleteGame);
        jbDeleteGame.addActionListener(this);


        cartMid.setLayout(new BorderLayout());
        cartMid.add(scrollTable);
        eastPanel.add(cartMid, "Center");

        usernameValue = new JLabel(username);
//        eastPanel.add(cartPanel);

    }

    public void delFile(String gameID) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/dummyGame.txt"));


            for (int i = 0; i < lines.size(); i++) {
                String[] tokens = lines.get(i).split(",");
                if (tokens[0].equals(gameID)) {
                    lines.remove(i);
                    break;
                }
            }


            Files.write(Paths.get("src/dummyGame.txt"), lines);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public adminGameSide(String username)
    {

        initComp(username);
        loadGameData();
        loadTable();
        gameTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = gameTable.getSelectedRow();


            }
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        new adminGameSide("tes");
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        int selectedRows = gameTable.getSelectedRow();
        if(e.getSource().equals(homeButton)) {
            AdminHome adminHome = new AdminHome(usernameValue.getText());
            adminHome.setVisible(true);
            this.dispose();
            return;
        }

        if(e.getSource().equals(jbAddGame)) {
            AddGame addGame = new AddGame(usernameValue.getText());
            addGame.setVisible(true);
            this.dispose();
            return;
        }

        if(e.getSource().equals(jbUpdateGame)) {
            if (selectedRows == -1) {
                JOptionPane.showMessageDialog(null, "Please select one row to update");
            }else {
                String gameID = (String) gameTable.getValueAt(selectedRows, 0);
                UpdateGame updateGame = new UpdateGame(gameID, usernameValue.getText());
                updateGame.setVisible(true);
                this.dispose();
            }
        }
        if(e.getSource().equals(jbDeleteGame)){
            if (selectedRows == -1) {
                JOptionPane.showMessageDialog(null, "Please select one row to update");
            }else {
                String gameID = (String) gameTable.getValueAt(selectedRows, 0);
                delFile(gameID);
                model.removeRow(selectedRows);
                games.remove(selectedRows);
                gameTable.invalidate();
            }
        }
    }
}