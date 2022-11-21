package bussinesLayer;

import dataLayer.FileWriterClass;
import dataLayer.MapSerializator;
import presentationLayer.EmployeeGUI;
import users.Client;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class DeliveryService extends Observable implements IDeliveryServiceProcessing {
    private HashMap<String, MenuItem> products = new HashMap<>();
    private ArrayList<MenuItem> menuItems = new ArrayList<>();
    private ArrayList<MenuItem> productsToOrder = new ArrayList<>();
    private Map<Order, ArrayList<MenuItem>> orders = new HashMap<>();
    private FileWriterClass fileWriterClass = new FileWriterClass();
    private MapSerializator mapSerializator = new MapSerializator();

    public HashMap<String, MenuItem> getProducts() { return products; }
    public void setProducts(HashMap<String, MenuItem> products) { this.products = products; }
    public ArrayList<MenuItem> getMenuItems() { return menuItems; }
    public void setMenuItems(ArrayList<MenuItem> menuItems) { this.menuItems = menuItems; }

    @Override
    public void importProducts() {
        var fileName = "C:\\UTCN\\AN 3 SEM 2\\TP\\PT2022_30227_Madalina_Marc_Assignment_4\\products.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            List<String> lines;
            lines = br.lines().skip(1).collect(Collectors.toList());
            lines = lines.stream().distinct().collect(Collectors.toList());
            List<String[]> list;
            list = lines.stream().map(line -> line.split(",")).collect(Collectors.toList());
            StringBuilder sb = new StringBuilder();
            for (String[] i: list){
                products.put(i[0], new BaseProduct(i[0], Double.parseDouble(i[1]), Integer.parseInt(i[2]), Integer.parseInt(i[3]), Integer.parseInt(i[4]), Integer.parseInt(i[5]), Integer.parseInt(i[6])));
                sb.append(i[0]).append(" ").append(i[1]).append(" ").append(i[2]).append(" ").append(i[3]).append(" ").append(i[4]).append(" ").append(i[5]).append(" ").append(i[6]).append("\n");
                menuItems.add(new BaseProduct(i[0], Double.parseDouble(i[1]), Integer.parseInt(i[2]), Integer.parseInt(i[3]), Integer.parseInt(i[4]), Integer.parseInt(i[5]), Integer.parseInt(i[6]))); }
        } catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
    }

    @Override
    public ArrayList<MenuItem> viewList() { return menuItems; }

    @Override
    public Boolean wellFormed(MenuItem m) {
        if (m.getRating() < 0) return false;
        else if (m.getCalories() < 0 || m.getCalories() % 1 != 0) return false;
        else if (m.getProtein() < 0 || m.getProtein() % 1 != 0) return false;
        else if (m.getFat() < 0 || m.getFat() % 1 != 0) return false;
        else if (m.getSodium() < 0 || m.getSodium() % 1 != 0) return false;
        else if (m.getPrice() < 0 || m.getPrice() % 1 != 0) return false;
        return true; }

    @Override
    public boolean addProduct(String title, double rating, int calories, int protein, int fat, int sodium, int price) {
        assert title.equals("") : "Incorrect title";
        MenuItem m = new BaseProduct(title, rating, calories, protein, fat, sodium, price);
        assert wellFormed(m) : "Incorrect input";
        boolean ok = true;
        for (MenuItem menuItem: menuItems)
            if (menuItem.getTitle().equals(title)) {
                ok = false;
                break; }
        if(ok){
            menuItems.add(m);
            return true; }
        return false; }
    @Override
    public boolean deleteProduct(String title) {
        boolean ok = false;
        assert title.equals("") : "Incorrect title";
        for (MenuItem m: menuItems)
            if (m.getTitle().equals(title)){
                menuItems.remove(m);
                ok = true;
                break; }
        return ok; }

    @Override
    public ArrayList<MenuItem> modifyProductByRating(String title, double rating) {
        assert !title.equals("");
        assert rating >= 0;
        for (MenuItem m: menuItems) if (m.getTitle().equals(title)) m.setRating(rating);
        return menuItems;
    }
    @Override
    public ArrayList<MenuItem> modifyProductByCalories(String title, int calories) {
        assert !title.equals("");
        assert calories >= 0 && calories % 1 == 0;
        for (MenuItem m: menuItems) if (m.getTitle().equals(title)) m.setCalories(calories);
        return menuItems;
    }
    @Override
    public ArrayList<MenuItem> modifyProductByProtein(String title, int protein) {
        assert !title.equals("");
        assert protein >= 0 && protein % 1 == 0;
        for (MenuItem m: menuItems) if (m.getTitle().equals(title)) m.setProtein(protein);
        return menuItems;
    }
    @Override
    public ArrayList<MenuItem> modifyProductByFat(String title, int fat) {
        assert !title.equals("");
        assert fat >= 0 && fat % 1 == 0;
        for (MenuItem m: menuItems) if (m.getTitle().equals(title)) m.setFat(fat);
        return menuItems;
    }
    @Override
    public ArrayList<MenuItem> modifyProductBySodium(String title, int sodium) {
        assert !title.equals("");
        assert sodium >= 0 && sodium % 1 == 0;
        for (MenuItem m: menuItems) if (m.getTitle().equals(title)) m.setSodium(sodium);
        return menuItems;
    }
    @Override
    public ArrayList<MenuItem> modifyProductByPrice(String title, int price) {
        assert !title.equals("");
        assert price >= 0 && price % 1 == 0;
        for (MenuItem m: menuItems) if (m.getTitle().equals(title)) m.setPrice(price);
        return menuItems;
    }

    @Override
    public ArrayList<MenuItem> searchByTitle(String title) {
        assert !title.equals("");
        return (ArrayList<MenuItem>) menuItems.stream()
                .filter(e -> e.getTitle().equals(title))
                .collect(Collectors.toList());
    }
    @Override
    public ArrayList<MenuItem> searchByRating(double rating) {
        assert rating >= 0;
        return (ArrayList<MenuItem>) menuItems.stream()
                .filter(e -> e.getRating() == rating)
                .collect(Collectors.toList());
    }
    @Override
    public ArrayList<MenuItem> searchByCalories(int calories) {
        assert calories >= 0 && calories % 1 == 0;
        return (ArrayList<MenuItem>) menuItems.stream()
                .filter(e -> e.getCalories() == calories)
                .collect(Collectors.toList());
    }
    @Override
    public ArrayList<MenuItem> searchByProtein(int protein) {
        assert protein >= 0 && protein % 1 == 0;
        return (ArrayList<MenuItem>) menuItems.stream()
                .filter(e -> e.getProtein() == protein)
                .collect(Collectors.toList());
    }
    @Override
    public ArrayList<MenuItem> searchByFat(int fat) {
        assert fat >= 0 && fat % 1 == 0;
        return (ArrayList<MenuItem>) menuItems.stream()
                .filter(e -> e.getFat() == fat)
                .collect(Collectors.toList());
    }
    @Override
    public ArrayList<MenuItem> searchBySodium(int sodium) {
        assert sodium >= 0 && sodium % 1 == 0;
        return (ArrayList<MenuItem>) menuItems.stream()
                .filter(e -> e.getSodium() == sodium)
                .collect(Collectors.toList());
    }
    @Override
    public ArrayList<MenuItem> searchByPrice(int price) {
        assert price >= 0 && price % 1 == 0;
        return (ArrayList<MenuItem>) menuItems.stream()
                .filter(e -> e.getPrice() == price)
                .collect(Collectors.toList());
    }

    @Override
    public void addProductToOrder(String title) {
        MenuItem aux = null;
        for (MenuItem m: menuItems)
            if (m.getTitle().equals(title)) {
                aux = m;
                System.out.println(aux.getTitle());
                break; }
        if (aux != null) productsToOrder.add(aux);
    }
    @Override
    public void createOrder(int idClient){
        int totalPrice = productsToOrder.stream()
                .map(element->element.computePrice())
                .reduce(0,(subtotal, element) -> subtotal + element);
        Order o = new Order(idClient, orders.keySet().size(), Calendar.getInstance().getTime(), totalPrice);
        orders.put(o, productsToOrder);

        mapSerializator.serialize(orders);
        fileWriterClass.writeBill(o, productsToOrder);
        productsToOrder.clear();
        orders = mapSerializator.deserialize();
        
        setChanged();
        notifyObservers(orders.get(o));
    }

    @Override
    public Map<Order, ArrayList<MenuItem>> getOrders() {
        return orders;
    }

    @Override
    public void setOrders(Map<Order, ArrayList<MenuItem>> orders) {
        this.orders = orders;
    }

    @Override
    public void addAllObservers(EmployeeGUI e){
        this.addObserver(e);
    }

    @Override
    public ArrayList<Order> createReport1(int startHour, int endHour){
        ArrayList<Order> result = new ArrayList<>();
        orders.keySet().forEach((order) -> {
            if (order.getOrderData().getHours() >= startHour && order.getOrderData().getHours() <= endHour)
                result.add(order);
        });
        return result;
    }
    @Override
    public ArrayList<MenuItem> createReport2(int numberOfTimesOrdered){
        HashMap<MenuItem, Integer> productsMap = new HashMap<>();
        orders.keySet().forEach((order) -> {
            ArrayList<MenuItem> list = orders.get(order);
            list.forEach((m) -> {
                if (productsMap.containsKey(m)){
                    productsMap.put(m, productsMap.get(m)+1);
                }else{
                    productsMap.put(m, 1); }
            });
        });
        ArrayList<MenuItem> result = new ArrayList<>();
        productsMap.keySet().forEach((menuItem) -> {
            if (productsMap.get(menuItem) > numberOfTimesOrdered)
                result.add(menuItem);
        });
        return result;
    }
    @Override
    public ArrayList<Client> createReport3(int limitOfPrice, int numberOfTimes, ArrayList<Client> listClients) {
        HashMap<Client, Integer> clientsMap = new HashMap<>();
        orders.keySet().forEach((order) -> {
            int total = 0;
            ArrayList<MenuItem> list = orders.get(order);
            for (MenuItem m: list) total += m.getPrice();
            Client client = null;
            if (total > limitOfPrice){
                for (Client c: listClients)
                    if (c.getId() == order.getIdClient()){
                        client = c;
                        break; } }
            if (client != null){
                if (clientsMap.containsKey(client))
                    clientsMap.put(client, clientsMap.get(client)+1);
                else
                    clientsMap.put(client, 1); }
        });
        ArrayList<Client> result = new ArrayList<>();
        clientsMap.keySet().forEach((client) -> {
            if (clientsMap.get(client) >= numberOfTimes)
                result.add(client);
        });
        return result;
    }
    @Override
    public HashMap<MenuItem, Integer> createReport4(int day) {
        HashMap<MenuItem, Integer> productsMap = new HashMap<>();
        orders.keySet().forEach((order) -> {
            if (day == order.getOrderData().getDay()){
                orders.get(order).forEach((menuItem) -> {
                    if (productsMap.containsKey(menuItem))
                        productsMap.put(menuItem, productsMap.get(menuItem)+1);
                    else
                        productsMap.put(menuItem, 1);
                }); }
        });
        return productsMap;
    }

    private ArrayList<MenuItem> stringToMenuItem(List<String> itemsString){
        ArrayList<MenuItem> list = new ArrayList<>();
        itemsString.forEach((s) -> {
            menuItems.forEach((menuItem) -> { if (s.equals(menuItem.getTitle())) list.add(menuItem); });
        });
        return list;
    }
    @Override
    public void createCompositeProduct(String title, List<String> list) {
        ArrayList<MenuItem> itemsMenuItem = stringToMenuItem(list);
        menuItems.add(new CompositeProduct(title, itemsMenuItem));
    }
}
