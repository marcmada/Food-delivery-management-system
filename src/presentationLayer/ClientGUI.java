package presentationLayer;

import bussinesLayer.MenuItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ClientGUI extends JFrame{
    private JButton buttonLogin = new JButton("Log in");
    private JButton buttonRegister = new JButton("Register");
    private JButton buttonViewProducts = new JButton("View the list of products");
    private JButton buttonSearch = new JButton("Search products");
    private JButton buttonCreateOrder = new JButton("Create order");
    private JButton buttonBack = new JButton("Back to log in page");
    private JButton buttonAddProductToOrder = new JButton("Add product to order");

    private JLabel username = new JLabel("username: ");
    private JLabel password = new JLabel("password: ");
    public JTextField usernameText = new JTextField(15);
    public JPasswordField passwordText = new JPasswordField(15);
    public JTextField filterField = new JTextField("Type the value");

    private JButton buttonFilter = new JButton("Filter the products");
    private String[] columns = {"title", "rating", "calories", "protein", "fat", "sodium", "price"};
    private JComboBox comboBox = new JComboBox(columns);

    DefaultTableModel table1 = new DefaultTableModel(columns, 0);
    JTable elementsTable = new JTable(table1);
    JTable table = new JTable();

    public ClientGUI(){
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        GridLayout gridLayout = new GridLayout(5, 1);
        gridLayout.setVgap(10);

        buttonLogin.setBackground(Color.MAGENTA);
        buttonRegister.setBackground(Color.MAGENTA);
        buttonSearch.setBackground(Color.MAGENTA);
        buttonCreateOrder.setBackground(Color.MAGENTA);
        buttonViewProducts.setBackground(Color.MAGENTA);
        buttonAddProductToOrder.setBackground(Color.MAGENTA);
        panel1.add(buttonLogin);
        panel1.add(buttonRegister);
        panel1.add(buttonViewProducts);
        panel1.add(buttonSearch);
        panel1.add(buttonAddProductToOrder);
        panel1.add(buttonCreateOrder);
        panel1.add(buttonBack);

        JScrollPane scrollPane = new JScrollPane(elementsTable);
        panel2.add(table);
        panel2.add(scrollPane);

        panel.setOpaque(true);
        panel.setBackground(Color.BLACK);
        panel1.setBackground(Color.BLACK);
        panel1.setLayout(gridLayout);
        panel1.add(buttonFilter);

        panel1.add(comboBox);
        panel1.add(filterField);

        panel.add(panel1);
        panel.add(panel2);

        this.setSize(500, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(panel);
        this.setTitle("Client");
        this.pack();
    }

    public void populateTable(ArrayList<MenuItem> products){
        for (MenuItem m: products){
            String[] item={m.getTitle(), String.valueOf(m.getRating()), String.valueOf(m.getCalories()), String.valueOf(m.getProtein()), String.valueOf(m.getFat()), String.valueOf(m.getSodium()), String.valueOf(m.getPrice())};
            table1.addRow(item);
        }
    }

    public ClientGUI(boolean ok){
        if (ok == true) {
            passwordText.setEchoChar('*');
            JPanel panel1 = new JPanel();
            panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
            JPanel panel2 = new JPanel();
            panel2.add(username);
            panel2.add(usernameText);
            JPanel panel3 = new JPanel();
            panel3.add(password);
            panel3.add(passwordText);
            panel1.add(panel2);
            panel1.add(panel3);
            panel1.add(buttonLogin);
            panel1.add(buttonRegister);

            this.add(panel1);
            this.setTitle("Client");
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.pack();
        }
    }

    public JButton getButtonLogin() { return buttonLogin; }

    public JButton getButtonRegister() { return buttonRegister; }

    public JButton getButtonViewProducts() { return buttonViewProducts; }

    public JButton getButtonSearch() { return buttonSearch; }

    public JButton getButtonCreateOrder() { return buttonCreateOrder; }

    public JButton getButtonBack() { return buttonBack; }

    public JLabel getUsername() { return username; }

    public JLabel getPassword() { return password; }

    public JTextField getUsernameText() { return usernameText; }

    public JPasswordField getPasswordText() { return passwordText; }

    public JTextField getFilterField() { return filterField; }

    public JComboBox getComboBox() { return comboBox; }

    public DefaultTableModel getTable1() { return table1; }

    public JButton getButtonAddProductToOrder() { return buttonAddProductToOrder; }
}
