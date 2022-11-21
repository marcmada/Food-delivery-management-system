package start;

import presentationLayer.*;

public class Main {

    public static void main(String[] args){
        BasicGUI basicGUI = new BasicGUI();
        ClientGUI clientGUI = new ClientGUI();
        EmployeeGUI employeeGUI = new EmployeeGUI();
        AdministratorGUI administratorGUI = new AdministratorGUI();
        Controller c = new Controller(basicGUI, clientGUI, employeeGUI, administratorGUI);

        basicGUI.setVisible(true);

        /*List<Employee> administrators = new ArrayList<>();
        administrators.add(new Employee(1, "ana", "12345678", null));
        administrators.add(new Employee(2, "georgiana", "12345678", null));
        //AdministratorSerializator administratorSerializator = new AdministratorSerializator();
        //ClientSerializator clientSerializator = new ClientSerializator();
        EmployeeSerializator employeeSerializator = new EmployeeSerializator();
        employeeSerializator.serialize(administrators);*/
    }
}
