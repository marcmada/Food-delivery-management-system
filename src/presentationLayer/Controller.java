package presentationLayer;

import bussinesLayer.*;
import bussinesLayer.MenuItem;
import dataLayer.FileWriterClass;
import dataLayer.MapSerializator;
import dataLayer.ProductSerializator;
import users.Administrator;
import users.Client;
import users.Employee;

import javax.swing.*;
import java.util.*;

public class Controller {
    int id = 0;
    public BasicGUI basicGUI;
    public ClientGUI clientGUI;
    public EmployeeGUI employeeGUI;
    public AdministratorGUI administratorGUI;
    public AdministratorGUI administratorGUI2;
    public AdministratorGUI administratorGUILogin;
    public ClientGUI clientGUILogin;
    public EmployeeGUI employeeGUILogin;
    public Authentication authentication = new Authentication();
    private IDeliveryServiceProcessing deliveryService = new DeliveryService();
    private Random random = new Random();
    public List<MenuItem> orders = new ArrayList<>();
    public ProductSerializator productSerializator = new ProductSerializator();
    public MapSerializator mapSerializator = new MapSerializator();
    public FileWriterClass fileWriterClass = new FileWriterClass();
    public List<String> productsCreate = new ArrayList<>();

    public Controller(BasicGUI basicGUI, ClientGUI clientGUI, EmployeeGUI employeeGUI, AdministratorGUI administratorGUI) {
        this.basicGUI = basicGUI;
        this.clientGUI = clientGUI;
        this.employeeGUI = employeeGUI;
        this.administratorGUI = administratorGUI;
        this.administratorGUI2 =  new AdministratorGUI(true);
        this.administratorGUILogin =  new AdministratorGUI(1);
        this.clientGUILogin = new ClientGUI(true);
        this.employeeGUILogin = new EmployeeGUI(true);
        deliveryService.setMenuItems((ArrayList<MenuItem>) productSerializator.deserialize());
        deliveryService.setOrders(mapSerializator.deserialize());
        clientGUI.populateTable(deliveryService.viewList());
        deliveryService.addAllObservers(employeeGUI);

        basicGUI.getButtonClient().addActionListener(e -> {
            basicGUI.setVisible(false);
            clientGUILogin.setVisible(true);
            employeeGUILogin.setVisible(true);
        });
        basicGUI.getButtonAdministrator().addActionListener(e -> {
            basicGUI.setVisible(false);
            administratorGUILogin.setVisible(true);
        });
        clientGUILogin.getButtonLogin().addActionListener(e -> {
            Client c = new Client(id, clientGUILogin.getUsernameText().getText(), clientGUILogin.getPasswordText().getText());
            boolean b = authentication.authenticationClient(c.getUsername(), c.getPassword());
            if (b == false) JOptionPane.showMessageDialog(null, "Your name and/or password are not correct", "Incorrect details", JOptionPane.INFORMATION_MESSAGE);
            else {
                clientGUILogin.setVisible(false);
                clientGUI.setVisible(true);
            }
        });
        employeeGUILogin.getButtonLogin().addActionListener(e -> {
            Employee em = new Employee(id, employeeGUILogin.getUsernameText().getText(), employeeGUILogin.getPasswordText().getText(), null);
            boolean b = authentication.authenticationEmployee(em.getUsername(), em.getPassword());
            if (b == false) JOptionPane.showMessageDialog(null, "Your name and/or password are not correct", "Incorrect details", JOptionPane.INFORMATION_MESSAGE);
            else{
                employeeGUILogin.setVisible(false);
                employeeGUI.setVisible(true);
            }
        });
        administratorGUILogin.getButtonLogin().addActionListener(e -> {
            Administrator a = new Administrator(id, administratorGUILogin.getUsernameText().getText(), administratorGUILogin.getPasswordText().getText());
            boolean b = authentication.authenticationAdministrator(a.getUsername(), a.getPassword());
            if (b == false) JOptionPane.showMessageDialog(null, "Your name and/or password are not correct", "Incorrect details", JOptionPane.INFORMATION_MESSAGE);
            else {
                administratorGUILogin.setVisible(false);
                administratorGUI.setVisible(true);
            }
        });
        clientGUILogin.getButtonRegister().addActionListener(e -> {
            Client c = new Client(random.nextInt(100), clientGUILogin.getUsernameText().getText(), clientGUILogin.getPasswordText().getText());
            if (c.getUsername().length() == 0) JOptionPane.showMessageDialog(null, "You must enter a username", "Incorrect details", JOptionPane.INFORMATION_MESSAGE);
            else if (c.getPassword().length() < 8) JOptionPane.showMessageDialog(null, "Your password must be at least 8 characters", "Incorrect details", JOptionPane.INFORMATION_MESSAGE);
            else{
                authentication.registerClient(c.getId(), c.getUsername(), c.getPassword());
                clientGUILogin.setVisible(false);
                clientGUI.setVisible(true);}
        });

        ///metoda de login
        clientGUI.getButtonLogin().addActionListener(e -> {
            clientGUI.setVisible(false);
            clientGUILogin.setVisible(true);
        });
        ///metoda de register
        clientGUI.getButtonRegister().addActionListener(e -> {
            clientGUI.setVisible(false);
            clientGUILogin.setVisible(true);
        });

        clientGUI.getButtonBack().addActionListener(e -> {
            clientGUI.setVisible(false);
            basicGUI.setVisible(true);
        });
        employeeGUI.getButtonBack().addActionListener(e -> {
            employeeGUI.setVisible(false);
            basicGUI.setVisible(true);
        });
        administratorGUI.getButtonBack().addActionListener(e -> {
            administratorGUI.setVisible(false);
            basicGUI.setVisible(true);
        });
        administratorGUI.getButtonImportProducts().addActionListener(e -> {
            deliveryService.importProducts();
        });
        administratorGUI2.getButtonBack().addActionListener(e -> {
            administratorGUI2.setVisible(false);
            basicGUI.setVisible(true);
        });
        administratorGUI2.getButtonBackAdmin().addActionListener(e -> {
            administratorGUI2.setVisible(false);
            administratorGUI.setVisible(true);
        });

        administratorGUI.getButtonGenerateReports().addActionListener(e -> {
            administratorGUI.setVisible(false);
            administratorGUI2.setVisible(true);
        });

        clientGUI.getButtonViewProducts().addActionListener(e -> {
            deliveryService.viewList();
        });

        clientGUI.getButtonSearch().addActionListener(e -> {
            ArrayList<MenuItem> list;
            String columnsName = clientGUI.getComboBox().getSelectedItem().toString();
            String columnsValue = clientGUI.getFilterField().getText();
            clientGUI.getTable1().setRowCount(0);
            if (columnsName.equals("title")){
                list = deliveryService.searchByTitle(columnsValue);
                clientGUI.populateTable(list);
            }
            if (columnsName.equals("rating")){
                list = deliveryService.searchByRating(Double.parseDouble(columnsValue));
                clientGUI.populateTable(list);
            }
            if (columnsName.equals("calories")){
                list = deliveryService.searchByCalories(Integer.parseInt(columnsValue));
                clientGUI.populateTable(list);
            }
            if (columnsName.equals("protein")){
                list = deliveryService.searchByProtein(Integer.parseInt(columnsValue));
                clientGUI.populateTable(list);
            }
            if (columnsName.equals("fat")){
                list = deliveryService.searchByFat(Integer.parseInt(columnsValue));
                clientGUI.populateTable(list);
            }
            if (columnsName.equals("sodium")){
                list = deliveryService.searchBySodium(Integer.parseInt(columnsValue));
                clientGUI.populateTable(list);
            }
            if (columnsName.equals("price")){
                list = deliveryService.searchByPrice(Integer.parseInt(columnsValue));
                clientGUI.populateTable(list);
            }
        });
        administratorGUI.getButtonModify().addActionListener(e -> {
            String title = administratorGUI.getTitleField().getText();
            String rating = administratorGUI.getRatingField().getText();
            String calories = administratorGUI.getCaloriesField().getText();
            String protein = administratorGUI.getProteinField().getText();
            String fat = administratorGUI.getFatField().getText();
            String sodium = administratorGUI.getSodiumField().getText();
            String price = administratorGUI.getPriceField().getText();
            ArrayList<MenuItem> list = deliveryService.searchByTitle(title);

            clientGUI.getTable1().setRowCount(0);
            if (!rating.equals("Rating"))
                list = deliveryService.modifyProductByRating(title, Double.parseDouble(rating));
            if (!calories.equals("Calories"))
                list = deliveryService.modifyProductByCalories(title, Integer.parseInt(calories));
            if (!protein.equals("Protein"))
                list = deliveryService.modifyProductByProtein(title, Integer.parseInt(protein));
            if (!fat.equals("Fat"))
                list = deliveryService.modifyProductByFat(title, Integer.parseInt(fat));
            if (!sodium.equals("Sodium"))
                list = deliveryService.modifyProductBySodium(title, Integer.parseInt(sodium));
            if (!price.equals("Price"))
                list = deliveryService.modifyProductByPrice(title, Integer.parseInt(price));

            clientGUI.populateTable(list);

        });
        clientGUI.getButtonViewProducts().addActionListener(e -> {
            clientGUI.getTable1().setRowCount(0);
            clientGUI.populateTable(deliveryService.viewList());
        });
        administratorGUI.getButtonAddProducts().addActionListener(e -> {
            String title = administratorGUI.getTitleField().getText();
            Double rating = Double.valueOf(administratorGUI.getRatingField().getText());
            int calories = Integer.parseInt(administratorGUI.getCaloriesField().getText());
            int protein = Integer.parseInt(administratorGUI.getProteinField().getText());
            int fat = Integer.parseInt(administratorGUI.getFatField().getText());
            int sodium = Integer.parseInt(administratorGUI.getSodiumField().getText());
            int price = Integer.parseInt(administratorGUI.getPriceField().getText());

            deliveryService.addProduct(title, rating, calories, protein, fat, sodium, price);
        });
        administratorGUI.getButtonDeleteProducts().addActionListener(e -> {
            String title = administratorGUI.getTitleField().getText();

            deliveryService.deleteProduct(title);
        });
        clientGUI.getButtonAddProductToOrder().addActionListener(e -> {
            String title = clientGUI.getFilterField().getText();
            deliveryService.addProductToOrder(title);
        });
        clientGUI.getButtonCreateOrder().addActionListener(e -> {
            deliveryService.createOrder(authentication.getIdClient());
        });
        clientGUI.addWindowListener(new java.awt.event.WindowAdapter(){
            @Override
            public void windowClosing(java.awt.event.WindowEvent e){
                productSerializator.serialize(deliveryService.getMenuItems());
                mapSerializator.serialize(deliveryService.getOrders());
                e.getWindow().dispose();
            }
        });
        employeeGUI.addWindowListener(new java.awt.event.WindowAdapter(){
            @Override
            public void windowClosing(java.awt.event.WindowEvent e){
                productSerializator.serialize(deliveryService.getMenuItems());
                mapSerializator.serialize(deliveryService.getOrders());
                e.getWindow().dispose();
            }
        });
        administratorGUI.addWindowListener(new java.awt.event.WindowAdapter(){
            @Override
            public void windowClosing(java.awt.event.WindowEvent e){
                productSerializator.serialize(deliveryService.getMenuItems());
                mapSerializator.serialize(deliveryService.getOrders());
                e.getWindow().dispose();
            }
        });

        administratorGUI2.getButtonReport1().addActionListener(e -> {
            int startHour = Integer.parseInt(administratorGUI2.getStartHour().getText());
            int endHour = Integer.parseInt(administratorGUI2.getEndHour().getText());
            ArrayList<Order> result = deliveryService.createReport1(startHour, endHour);
            fileWriterClass.report1(result);
        });
        administratorGUI2.getButtonReport2().addActionListener(e -> {
            int nrOrders = Integer.parseInt(administratorGUI2.getNumberOfTimesOrdered().getText());
            ArrayList<MenuItem> result = deliveryService.createReport2(nrOrders);
            fileWriterClass.report2(result);
        });
        administratorGUI2.getButtonReport3().addActionListener(e -> {
            int price = Integer.parseInt(administratorGUI2.getLimitsOfPrice().getText());
            int nrOrders = Integer.parseInt(administratorGUI2.getNumberOfTimes().getText());
            ArrayList<Client> result = deliveryService.createReport3(price, nrOrders, (ArrayList<Client>) authentication.getClients());
            fileWriterClass.report3(result);
        });
        administratorGUI2.getButtonReport4().addActionListener(e -> {
            int day = Integer.parseInt(administratorGUI2.getDays().getText());
            HashMap<MenuItem, Integer> result = deliveryService.createReport4(day);
            fileWriterClass.report4(result);
        });
        administratorGUI.getButtonAddCompositeProduct().addActionListener(e -> {
            String title = administratorGUI.getTitleField().getText();
            productsCreate.add(title);
        });
        administratorGUI.getButtonCreateCompositeProduct().addActionListener(e -> {
            String title = administratorGUI.getTitleField().getText(); //nume daily menu 1
            deliveryService.createCompositeProduct(title, productsCreate);
        });
    }

}
