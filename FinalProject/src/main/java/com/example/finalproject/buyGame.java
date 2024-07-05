package com.example.finalproject;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
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

public class buyGame extends JFrame implements ActionListener, DocumentListener
{

    private ArrayList<User> customerData = new ArrayList<>();
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
    private JButton myGameButton = new JButton("My Game");
    private JButton buyGameButton = new JButton("Buy Game");
    private JButton cartButton = new JButton("Cart");

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
    private JSlider priceSlider = new JSlider(JSlider.HORIZONTAL, 10000, 1000000, 10000);

    private JLabel labelSearch = new JLabel("Search Game:");
    private JTextField tfGame = new JTextField();
    private JComboBox comboSort = new JComboBox();

    private DefaultTableModel model;
    private JTable gameTable;
    private JScrollPane scrollTable = new JScrollPane(gameTable);
    private JPanel eastPanel = new JPanel();
    private JButton addToCart = new JButton("Add to cart");
    private JButton searchButton = new JButton("Search");

    private JPanel southEast = new JPanel();
    private JPanel southMid = new JPanel();
    private JPanel southWest = new JPanel();
    private ArrayList<Game>games = new ArrayList<>();
    private ArrayList<cartData> carts =  new ArrayList<>();

    private JLabel usernameVal;

    public void loadTable() {
        String[] tableTitle = {"ID", "Name", "Genre", "Quantity", "Price", "Publisher"};
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
    public void initComp(String username)
    {

        usernameVal = new JLabel(username);
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
//		homeButton.setSize(300, 300);
//		homeButton.setPreferredSize(new Dimension(navCenterPanel.getWidth()/2, navCenterPanel.getHeight()/2));
        navLinksPanel.add(homeButton);
        homeButton.addActionListener(this);
        myGameButton.setFont(new Font(getName(), ABORT, 15));
        navLinksPanel.add(myGameButton);
        myGameButton.addActionListener(this);
        buyGameButton.setFont(new Font(getName(), ABORT, 15));
        navLinksPanel.add(buyGameButton);
        cartButton.setFont(new Font(getName(), ABORT, 15));
        navLinksPanel.add(cartButton);
        cartButton.addActionListener(this);
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

        tfGame.addActionListener(this);

        northSouth.add(priceSlider);
        priceSlider.setMinorTickSpacing(10000);
        priceSlider.setMajorTickSpacing(990000);
        priceSlider.setPaintTicks(true);
        priceSlider.setPaintLabels(true);
        priceSlider.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e)
            {

            }
        });
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
        cartSouth.add(southMid, "Center");
        southMid.add(searchButton);

        cartSouth.add(southWest, "West");
        southEast.add(addToCart);

        eastPanel.add(cartMid, "Center");
        cartMid.setLayout(new BorderLayout());
        gameTable = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            public Class getColumnClass(int column) {
                switch(column) {
                    default :
                        return String.class;
                }
            }
        };
        scrollTable = new JScrollPane(gameTable);
        cartMid.add(scrollTable);
        addToCart.addActionListener(this);
        //
//        tfGame.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                filterTable();
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                filterTable();
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                filterTable();
//            }
//            public void filterTable()
//            {
//                String search = tfGame.getText().toLowerCase();
//                RowFilter<Object, Object> filter = new RowFilter<Object, Object>() {
//                    @Override
//                    public boolean include(Entry<?, ?> entry) {
//                        for(int i = 0;i < entry.getValueCount(); i++)
//                        {
//                            if(entry.getStringValue(i).toLowerCase().contains(search))
//                            {
//                                return true;
//                            }
//                        }
//                        return false;
//                    }
//                };
//                TableRowSorter<DefaultTableModel> sorter = (TableRowSorter<DefaultTableModel>) gameTable.getRowSorter();
//                sorter.setRowFilter(filter);
//            }
//        });


    }
    private void updateTableModel(String query)
    {
        DefaultTableModel originalModel = (DefaultTableModel) gameTable.getModel();
        DefaultTableModel filteredModel = new DefaultTableModel();
        for (int i = 0; i < originalModel.getColumnCount(); i++) {
            filteredModel.addColumn(originalModel.getColumnName(i));
        }
        for (int row = 0; row < originalModel.getRowCount(); row++) {
            boolean matches = false;
            for (int col = 0; col < originalModel.getColumnCount(); col++) {
                Object value = originalModel.getValueAt(row, col);
                if (value != null && value.toString().contains(query)) {
                    matches = true;
                    break;
                }
            }
            if (matches) {
                filteredModel.addRow(new Object[] {
                        originalModel.getValueAt(row, 0),
                        originalModel.getValueAt(row, 1),
                        originalModel.getValueAt(row, 2)
                });
            }
        }

        // Set the new table model
        gameTable.setModel(filteredModel);;
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

    public buyGame(String username, ArrayList<User> cus)
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


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(homeButton))
        {
            CusHome cusHome = new CusHome(usernameVal.getText(), customerData);
            cusHome.setVisible(true);
            this.dispose();
        }
        if(e.getSource().equals(tfGame))
        {
            System.out.println("p");
        }

        int selectedRows = gameTable.getSelectedRow();
        if(e.getSource().equals(addToCart))
        {
            if(selectedRows == -1)
            {
                JOptionPane.showMessageDialog(null, "Please select one data to add to cart");}
            else
            {
                String gameTitle = (String) gameTable.getValueAt(selectedRows, 1);
                int gamePrice = (Integer) gameTable.getValueAt(selectedRows, 4);
                String gamePublisher = (String) gameTable.getValueAt(selectedRows, 5);
                carts.add(new cartData(gameTitle, gamePublisher, gamePrice));
                JOptionPane.showMessageDialog(null, "Successfully add to cart!");
                for (cartData i: carts)
                {
                    System.out.println(i.getGamePublisher());
                }
            }
        }
        if(e.getSource().equals(cartButton))
        {
            Cart cart = new Cart(carts, usernameVal.getText(), games, customerData);
            cart.setVisible(true);
            this.dispose();
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {

    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}