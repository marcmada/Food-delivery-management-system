package users;

import bussinesLayer.MenuItem;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A class used for an employee.
 */
public class Employee extends User implements Serializable {
    @Serial
    private final static long serialVersionUID = 3;
    private List<MenuItem> orders;

    /**
     * A constructor for a new employee.
     * @param id - employee's id
     * @param username - employee's username
     * @param password - employee's password
     */
    public Employee(int id, String username, String password, List<MenuItem> orders) {
        super(id, username, password);
        orders = new ArrayList<>();
    }

    public List<MenuItem> getOrders() { return orders; }

    public void setOrders(List<MenuItem> orders) { this.orders = orders; }

    @Override
    public String toString() {
        return "Employee: " + "id = " + id +
                " username = " + username + " password = " +
                password + "orders = " + orders + "\n";
    }
}
