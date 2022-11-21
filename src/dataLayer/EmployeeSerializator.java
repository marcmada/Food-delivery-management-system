package dataLayer;

import users.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSerializator {
    public void serialize(List<Employee> employees){
        try{
            FileOutputStream fileOut = new FileOutputStream("C:\\UTCN\\AN 3 SEM 2\\TP\\PT2022_30227_Madalina_Marc_Assignment_4\\employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            employees.forEach(elem -> {
                try {
                    out.writeObject(elem);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            out.flush();
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in employee.ser");
        } catch (UnsupportedEncodingException e) {}
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }

    public List<Employee> deserialize(){
        List<Employee> employees = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream("C:\\UTCN\\AN 3 SEM 2\\TP\\PT2022_30227_Madalina_Marc_Assignment_4\\employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Employee o = (Employee) in.readObject();
            while(o != null){
                employees.add(o);
                o = (Employee) in.readObject();
            }
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
        }
        System.out.println("Deserialized employee...");
        return employees;
    }
}
