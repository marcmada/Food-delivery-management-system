package dataLayer;

import users.Administrator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AdministratorSerializator {
    public void serialize(List<Administrator> admins){
        try{
            FileOutputStream fileOut = new FileOutputStream("C:\\UTCN\\AN 3 SEM 2\\TP\\PT2022_30227_Madalina_Marc_Assignment_4\\administrator.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            admins.forEach(elem -> {
                try {
                    out.writeObject(elem);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            out.flush();
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in administrator.ser");
        } catch (UnsupportedEncodingException e) {}
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }

    public List<Administrator> deserialize(){
        List<Administrator> admins = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream("C:\\UTCN\\AN 3 SEM 2\\TP\\PT2022_30227_Madalina_Marc_Assignment_4\\administrator.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Administrator a = (Administrator) in.readObject();
            while(a != null){
                admins.add(a);
                a = (Administrator) in.readObject();
            }
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Administrator class not found");
            c.printStackTrace();
        }
        System.out.println("Deserialized administrator...");
        return admins;
    }
}
