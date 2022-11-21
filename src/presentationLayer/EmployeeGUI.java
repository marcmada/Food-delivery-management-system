package presentationLayer;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeGUI extends JFrame implements Observer{
    private JButton buttonLogin = new JButton("Log in");
    private JButton buttonBack = new JButton("Back to log in page");

    private JLabel username = new JLabel("username: ");
    private JLabel password = new JLabel("password: ");
    public JTextField usernameText = new JTextField(15);
    public JPasswordField passwordText = new JPasswordField(15);
    private JTextArea notification = new JTextArea();

    public EmployeeGUI(){
        JPanel panel = new JPanel();
        GridLayout gridLayout = new GridLayout(5, 1);
        gridLayout.setVgap(10);

        panel.add(buttonBack);
        panel.add(notification);

        panel.setOpaque(true);
        panel.setBackground(Color.BLACK);
        panel.setLayout(gridLayout);

        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(panel);
        this.setTitle("Employee");
    }

    public EmployeeGUI(boolean ok){
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

            this.add(panel1);
            this.setTitle("Employee");
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.pack();
        }
    }

    public JButton getButtonLogin() { return buttonLogin; }

    public JLabel getUsername() { return username; }

    public JTextField getUsernameText() { return usernameText; }

    public JPasswordField getPasswordText() { return passwordText; }

    public JButton getButtonBack() {
        return buttonBack;
    }

    @Override
    public void update(Observable o, Object arg) {
        ArrayList<bussinesLayer.MenuItem> products = (ArrayList<bussinesLayer.MenuItem>) arg;
        String res = products.stream().map(product -> product.getTitle() + "\n").collect(Collectors.joining());
        notification.setText(res);
    }
}
