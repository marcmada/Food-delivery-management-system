package dataLayer;

import bussinesLayer.MenuItem;
import bussinesLayer.Order;
import users.Client;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class FileWriterClass {
    private File file;
    private FileWriter fileWrite;
    public void writeBill(Order order, List<MenuItem> items) {
        try {
            file = new File("C:\\UTCN\\AN 3 SEM 2\\TP\\PT2022_30227_Madalina_Marc_Assignment_4\\bill.txt");
            fileWrite = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fileWrite);
            bw.write("\n Bill \n");
            bw.write("Order id: " + order.getIdOrder() + "\n Client id: " + order.getIdClient() + "\n Price: " + order.getTotalPrice()  + "\n Date: " + order.getOrderData());
            bw.write("\n Product: ");
            for (MenuItem item : items) {
                bw.write("\n");
                bw.write(item.getTitle());
            }
            bw.close();
            fileWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void report1(ArrayList<Order> orders) {
        try {
            file = new File("C:\\UTCN\\AN 3 SEM 2\\TP\\PT2022_30227_Madalina_Marc_Assignment_4\\report1.txt");
            fileWrite = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fileWrite);
            bw.write("\n Report 1 \n");
            orders.stream().forEach((order) -> {
                try {
                    bw.write("Order's id: " + order.getIdOrder() + " Client's id: " + order.getIdClient() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            bw.close();
            fileWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void report2(ArrayList<MenuItem> menuItems) {
        try {
            file = new File("C:\\UTCN\\AN 3 SEM 2\\TP\\PT2022_30227_Madalina_Marc_Assignment_4\\report2.txt");
            fileWrite = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fileWrite);
            bw.write("\n Report 2 \n");
            menuItems.stream().forEach((menuItem) -> {
                try {
                    bw.write("Product's name: " + menuItem.getTitle() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            bw.close();
            fileWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void report3(ArrayList<Client> listClients) {
        try {
            file = new File("C:\\UTCN\\AN 3 SEM 2\\TP\\PT2022_30227_Madalina_Marc_Assignment_4\\report3.txt");
            fileWrite = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fileWrite);
            bw.write("\n Report 3 \n");
            listClients.stream().forEach((client) -> {
                try {
                    bw.write("Id client : " + client.getId() + " Client's name: " + client.getUsername() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            bw.close();
            fileWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void report4(HashMap<MenuItem, Integer> menuItems) {
        try {
            file = new File("C:\\UTCN\\AN 3 SEM 2\\TP\\PT2022_30227_Madalina_Marc_Assignment_4\\report4.txt");
            fileWrite = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fileWrite);
            bw.write("\n Report 3 \n");
            menuItems.forEach((menuItem, numberOfTimes) -> {
                try {
                    bw.write("Product's name: " + menuItem.getTitle() + " Number of times that the product was ordered: " + numberOfTimes + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            bw.close();
            fileWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
