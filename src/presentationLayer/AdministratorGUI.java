package presentationLayer;

import javax.swing.*;
import java.awt.*;

public class AdministratorGUI extends JFrame{
    private JButton buttonImportProducts = new JButton("Import products");
    private JButton buttonAddProducts = new JButton("Add product");
    private JButton buttonDeleteProducts = new JButton("Delete product");
    private JButton buttonGenerateReports = new JButton("Generate reports");
    private JButton buttonReport1 = new JButton("Report with orders within time interval");
    private JButton buttonReport2 = new JButton("Report with the products ordered a number of times");
    private JButton buttonReport3 = new JButton("Report with the clients that have ordered more than");
    private JButton buttonReport4 = new JButton("Report with the products order within a speificied day");
    private JButton buttonAddCompositeProduct = new JButton("Add to composite product");
    private JButton buttonCreateCompositeProduct = new JButton("Create composite product");
    private JButton buttonBack = new JButton("Back to log in page");
    private JButton buttonBackAdmin = new JButton("Back to Administrator page");
    private JButton buttonLogin = new JButton("Log in");
    private JButton buttonModify = new JButton("Modify the product");

    private JLabel username = new JLabel("username: ");
    private JLabel password = new JLabel("password: ");
    public JTextField usernameText = new JTextField(15);
    public JPasswordField passwordText = new JPasswordField(15);

    public JTextField titleField = new JTextField("Title");
    public JTextField ratingField = new JTextField("Rating");
    public JTextField caloriesField = new JTextField("Calories");
    public JTextField proteinField = new JTextField("Protein");
    public JTextField fatField = new JTextField("Fat");
    public JTextField sodiumField = new JTextField("Sodium");
    public JTextField priceField = new JTextField("Price");
    public JTextField startHour = new JTextField("Enter the start hour");
    public JTextField endHour = new JTextField("Enter the end hour");
    public JTextField numberOfTimesOrdered = new JTextField("Enter the limit of the number of a product can be ordered");
    public JTextField limitsOfPrice = new JTextField("Enter the limit of the price");
    public JTextField numberOfTimes = new JTextField("Enter the limit of the number of orders by a client");
    public JTextField days = new JTextField("Enter the day");

    public AdministratorGUI(){
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        GridLayout gridLayout = new GridLayout(7, 1);
        GridLayout gridLayout2 = new GridLayout(2, 1);
        gridLayout.setVgap(10);

        buttonImportProducts.setBackground(Color.MAGENTA);
        buttonAddProducts.setBackground(Color.MAGENTA);
        buttonDeleteProducts.setBackground(Color.MAGENTA);
        buttonModify.setBackground(Color.MAGENTA);
        buttonGenerateReports.setBackground(Color.MAGENTA);
        panel.add(buttonImportProducts);
        panel.add(buttonAddProducts);
        panel.add(buttonDeleteProducts);
        panel.add(buttonModify);
        panel.add(buttonGenerateReports);
        panel.add(buttonAddCompositeProduct);
        panel.add(buttonCreateCompositeProduct);
        panel.add(buttonBack);

        panel2.setOpaque(true);
        panel2.setBackground(Color.BLACK);
        panel1.setLayout(gridLayout);

        panel1.add(titleField);
        panel1.add(ratingField);
        panel1.add(caloriesField);
        panel1.add(proteinField);
        panel1.add(fatField);
        panel1.add(sodiumField);
        panel1.add(priceField);

        panel2.add(panel);
        panel2.add(panel1);
        panel2.setLayout(gridLayout2);

        this.setSize(700, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(panel2);
        this.setTitle("Administrator");
    }

    public AdministratorGUI(int ok){
        if (ok == 1) {
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

            this.add(panel1);
            this.setTitle("Administrator");
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.pack();
        }
    }

    public AdministratorGUI(boolean ok){
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        GridLayout gridLayout1 = new GridLayout(4, 1);
        gridLayout1.setVgap(10);
        GridLayout gridLayout2 = new GridLayout(5, 1);
        gridLayout2.setVgap(10);
        GridLayout gridLayout3 = new GridLayout(1, 2);
        gridLayout2.setVgap(10);

        if (ok == true){
            buttonReport1.setBackground(Color.MAGENTA);
            buttonReport2.setBackground(Color.MAGENTA);
            buttonReport3.setBackground(Color.MAGENTA);
            buttonReport4.setBackground(Color.MAGENTA);
            panel1.add(buttonReport1);
            panel1.add(buttonReport2);
            panel1.add(buttonReport3);
            panel1.add(buttonReport4);
            panel2.add(startHour);
            panel2.add(endHour);
            panel2.add(numberOfTimesOrdered);
            panel2.add(limitsOfPrice);
            panel2.add(numberOfTimes);
            panel2.add(days);
            panel2.add(buttonBack);
            panel2.add(buttonBackAdmin);

            panel1.setBackground(Color.BLACK);
            panel1.setLayout(gridLayout1);
            panel2.setLayout(gridLayout2);
            panel.setLayout(gridLayout3);

            panel.setOpaque(true);
            panel.setBackground(Color.BLACK);
            panel.add(panel1);
            panel.add(panel2);

            this.setSize(700, 450);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.add(panel);
            this.setTitle("Generate reports");
        }
    }

    public JButton getButtonImportProducts() {
        return buttonImportProducts;
    }

    public JButton getButtonAddProducts() {
        return buttonAddProducts;
    }

    public JButton getButtonDeleteProducts() {
        return buttonDeleteProducts;
    }

    public JButton getButtonGenerateReports() {
        return buttonGenerateReports;
    }

    public JButton getButtonReport1() {
        return buttonReport1;
    }

    public JButton getButtonReport2() {
        return buttonReport2;
    }

    public JButton getButtonReport3() {
        return buttonReport3;
    }

    public JButton getButtonReport4() {
        return buttonReport4;
    }

    public JButton getButtonBack() {
        return buttonBack;
    }

    public AbstractButton getButtonBackAdmin() {
        return buttonBackAdmin;
    }

    public JLabel getUsername() { return username; }

    public JTextField getUsernameText() { return usernameText; }

    public JPasswordField getPasswordText() { return passwordText; }

    public JButton getButtonLogin() { return buttonLogin; }

    public JTextField getTitleField() {
        return titleField;
    }

    public JTextField getRatingField() {
        return ratingField;
    }

    public JTextField getCaloriesField() {
        return caloriesField;
    }

    public JTextField getProteinField() {
        return proteinField;
    }

    public JTextField getFatField() {
        return fatField;
    }

    public JTextField getSodiumField() {
        return sodiumField;
    }

    public JTextField getPriceField() {
        return priceField;
    }

    public JButton getButtonModify() {
        return buttonModify;
    }

    public JTextField getStartHour() {
        return startHour;
    }

    public JTextField getEndHour() { return endHour; }

    public JTextField getNumberOfTimesOrdered() { return numberOfTimesOrdered; }

    public JTextField getLimitsOfPrice() { return limitsOfPrice; }

    public JTextField getNumberOfTimes() { return numberOfTimes; }

    public JTextField getDays() {
        return days;
    }

    public JButton getButtonAddCompositeProduct() { return buttonAddCompositeProduct; }

    public JButton getButtonCreateCompositeProduct() { return buttonCreateCompositeProduct; }
}
