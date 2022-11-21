package dataLayer;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import bussinesLayer.MenuItem;

public class ProductSerializator {
    /**
     *
     * Java provides a mechanism, called object serialization where an object can be represented as a sequence of bytes that includes the object's data,
     * as well as information about the object's type and the types of data stored in the object.
     * After a serialized object has been written into a file, it can be read from the file and deserialized that is, the type information and bytes
     * that represent the object and its data can be used to recreate the object in memory.
     * Most impressive is that the entire process is JVM independent, meaning an object can be serialized on one platform and deserialized on an entirely different platform.
     * Classes ObjectInputStream and ObjectOutputStream are high-level streams that contain the methods for serializing and deserializing an object.
     *
     * The ObjectOutputStream class is used to serialize an Object
     * This method serializes an Object and sends it to the output stream.
     */
    public void serialize(List<MenuItem> menuItems){
        try{
            FileOutputStream fileOut = new FileOutputStream("C:\\UTCN\\AN 3 SEM 2\\TP\\PT2022_30227_Madalina_Marc_Assignment_4\\menuItems.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(menuItems);
            out.flush();
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in menuItems.ser");
        } catch (UnsupportedEncodingException e) {}
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }

    /**
     * The ObjectInputStream class is used to deserialize an Object
     * This method retrieves the next Object out of the stream and deserializes it.
     * The return value is Object, so you will need to cast it to its appropriate data type.
     *
     * @return
     */
    public List<MenuItem> deserialize(){
        List<MenuItem> menuItems = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream("C:\\UTCN\\AN 3 SEM 2\\TP\\PT2022_30227_Madalina_Marc_Assignment_4\\menuItems.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            menuItems = (List<MenuItem>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Client class not found");
            c.printStackTrace();
        }
        System.out.println("Deserialized menu item...");
        return menuItems;
    }
}

