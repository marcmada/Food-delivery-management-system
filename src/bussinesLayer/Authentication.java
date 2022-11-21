package bussinesLayer;

import dataLayer.AdministratorSerializator;
import dataLayer.ClientSerializator;
import dataLayer.EmployeeSerializator;
import users.Administrator;
import users.Client;
import users.Employee;

import java.util.List;

public class Authentication {
    private List<Client> clients;
    private List<Administrator> administrators;
    private List<Employee> employees;
    private ClientSerializator clientSerializator;
    private AdministratorSerializator administratorSerializator;
    private EmployeeSerializator employeeSerializator;
    private DeliveryService deliveryService;
    private int idClient;

    public Authentication(){
        clientSerializator = new ClientSerializator();
        administratorSerializator = new AdministratorSerializator();
        employeeSerializator = new EmployeeSerializator();
        clients = clientSerializator.deserialize();
        administrators = administratorSerializator.deserialize();
        employees = employeeSerializator.deserialize();
        deliveryService = new DeliveryService();
        idClient = -1;
    }

    public boolean authenticationClient(String username, String password){
        for(Client client: clients)
            if (username.equals(client.getUsername()) && password.equals(client.getPassword())) {
                idClient = client.getId();
                return true;
            }
        return false;
    }
    public boolean authenticationEmployee(String username, String password){
        for(Employee employee: employees)
            if(username.equals(employee.getUsername()) && password.equals(employee.getPassword())) return true;
        return false;
    }

    public boolean authenticationAdministrator(String username, String password){
        for(Administrator administrator: administrators)
            if(username.equals(administrator.getUsername()) && password.equals(administrator.getPassword())) return true;
        return false;
    }
    public void registerClient(int id, String username, String password){
        Client c = new Client(id, username, password);
        clients.add(c);
        clients.forEach(client -> System.out.println("Id client: "+ client.getId()+ " Username: " + client.getUsername() + "\n"));
    }

    public List<Client> getClients() {
        return clients;
    }

    public int getIdClient() { return idClient; }

}
