package dataLayer;

import bussinesLayer.MenuItem;
import bussinesLayer.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapSerializator {
    public void serialize(Map<Order, ArrayList<MenuItem>> orders){
        try{
            FileOutputStream fileOut = new FileOutputStream("C:\\UTCN\\AN 3 SEM 2\\TP\\PT2022_30227_Madalina_Marc_Assignment_4\\map.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(orders);
            out.flush();
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in map.ser");
        } catch (UnsupportedEncodingException e) {}
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }

    public Map<Order, ArrayList<MenuItem>> deserialize(){
        Map<Order, ArrayList<MenuItem>> orders = new HashMap<>();
        try {
            FileInputStream fileIn = new FileInputStream("C:\\UTCN\\AN 3 SEM 2\\TP\\PT2022_30227_Madalina_Marc_Assignment_4\\map.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            orders = (Map) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
        return orders;
    }
}
