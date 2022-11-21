package presentationLayer;

import javax.swing.*;
import java.awt.*;

public class BasicGUI extends JFrame{
    private JButton buttonClient = new JButton("Log in as Client/Employee");
    private JButton buttonEmployee = new JButton("Log in as Employee");
    private JButton buttonAdministrator = new JButton("Log in as Administrator");

    public BasicGUI(){
        JPanel panel = new JPanel();
        GridLayout gridLayout = new GridLayout(2, 1);
        gridLayout.setVgap(10);

        buttonClient.setBackground(Color.MAGENTA);
        //buttonEmployee.setBackground(Color.MAGENTA);
        buttonAdministrator.setBackground(Color.MAGENTA);
        panel.add(buttonClient);
        //panel.add(buttonEmployee);
        panel.add(buttonAdministrator);

        panel.setOpaque(true);
        panel.setBackground(Color.BLACK);
        panel.setLayout(gridLayout);

        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(panel);
        this.setTitle("Log in system");
        this.setVisible(true);
    }

    public JButton getButtonClient() {
        return buttonClient;
    }

    public JButton getButtonAdministrator() {
        return buttonAdministrator;
    }
}
