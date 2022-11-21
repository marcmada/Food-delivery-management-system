package dataLayer;

import users.Client;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClientSerializator {
    public void serialize(List<Client> clients){
        try{
            FileOutputStream fileOut = new FileOutputStream("C:\\UTCN\\AN 3 SEM 2\\TP\\PT2022_30227_Madalina_Marc_Assignment_4\\client.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            clients.forEach(elem -> {
                try {
                    out.writeObject(elem);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            out.flush();
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in clients.ser");
        } catch (UnsupportedEncodingException e) {}
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }

    public List<Client> deserialize(){
        List<Client> clients = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream("C:\\UTCN\\AN 3 SEM 2\\TP\\PT2022_30227_Madalina_Marc_Assignment_4\\client.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Client c = (Client) in.readObject();
            while(c != null){
                clients.add(c);
                c = (Client) in.readObject();
            }
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Client class not found");
            c.printStackTrace();
        }
        System.out.println("Deserialized client...");
        return clients;
    }
}
