package bussinesLayer;

import presentationLayer.EmployeeGUI;
import users.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class contains the main operations that can be executed by the administrator and client.
 */
public interface IDeliveryServiceProcessing {
    public HashMap<String, MenuItem> getProducts();

    void setProducts(HashMap<String, MenuItem> products);

    ArrayList<MenuItem> getMenuItems();

    void setMenuItems(ArrayList<MenuItem> menuItems);

    /**
     * This method is used for importing the products from .csv file.
     * An administrator can import the products.
     */
    void importProducts();

    /**
     * This method is used for displaying all the products from .csv file.
     * @return a list with menu items
     */
    ArrayList<MenuItem> viewList();

    Boolean wellFormed(MenuItem m);

    /**
     * This method is used to add a product.
     * An administrator can add products.
     * @param title
     * @param rating
     * @param calories
     * @param protein
     * @param fat
     * @param sodium
     * @param price
     * @return true if the operation was successful - otherwise, it returns false.
     */
    boolean addProduct(String title, double rating, int calories, int protein, int fat, int sodium, int price);

    /**
     * This method is used to delete a product based on its title.
     * An administrator can delete products.
     * @param title
     * @return true if the operation was successful - otherwise, it returns false.
     */
    boolean deleteProduct(String title);

    /**
     * This method is used to modify the rating of a product based on its title.
     * An administrator can modify products.
     * @param rating
     * @return true if the operation was successful - otherwise, it returns false.
     */
    ArrayList<MenuItem> modifyProductByRating(String title, double rating);

    /**
     * This method is used to modify the number of calories of a product based on its title.
     * An administrator can modify products.
     * @param calories
     * @return true if the operation was successful - otherwise, it returns false.
     */
    ArrayList<MenuItem> modifyProductByCalories(String title, int calories);

    /**
     * This method is used to modify the number of protein of a product based on its title.
     * An administrator can modify products.
     * @param protein
     * @return true if the operation was successful - otherwise, it returns false.
     */
    ArrayList<MenuItem> modifyProductByProtein(String title, int protein);

    /**
     * This method is used to modify the number of fats of a product based on its title.
     * An administrator can modify products.
     * @param fat
     * @return true if the operation was successful - otherwise, it returns false.
     */
    ArrayList<MenuItem> modifyProductByFat(String title, int fat);

    /**
     * This method is used to modify the sodium of a product based on its title.
     * An administrator can modify products.
     * @param sodium
     * @return true if the operation was successful - otherwise, it returns false.
     */
    ArrayList<MenuItem> modifyProductBySodium(String title, int sodium);

    /**
     * This method is used to modify the price of a product based on its title.
     * An administrator can modify products.
     * @param price
     * @return true if the operation was successful - otherwise, it returns false.
     */
    ArrayList<MenuItem> modifyProductByPrice(String title, int price);

    /**
     * This method is used for searching the products that have the same title as the given one.
     * A client can search by title.
     * @param title
     * @return an arraylist with the products that match with the given title
     */
    ArrayList<MenuItem> searchByTitle(String title);

    /**
     * This method is used for searching the products that have the same rating as the given one.
     * A client can search by rating.
     * @param rating
     * @return an arraylist with the products that match with the given rating
     */
    ArrayList<MenuItem> searchByRating(double rating);

    /**
     * This method is used for searching the products that have the same calories as the given one.
     * A client can search by calories.
     * @param calories
     * @return an arraylist with the products that match with the given rating
     */
    ArrayList<MenuItem> searchByCalories(int calories);

    /**
     * This method is used for searching the products that have the same protein as the given one.
     * A client can search by protein.
     * @param protein
     * @return an arraylist with the products that match with the given protein
     */
    ArrayList<MenuItem> searchByProtein(int protein);

    /**
     * This method is used for searching the products that have the same fat as the given one.
     * A client can search by fat.
     * @param fat
     * @return an arraylist with the products that match with the given fat
     */
    ArrayList<MenuItem> searchByFat(int fat);

    /**
     * This method is used for searching the products that have the same sodium as the given one.
     * A client can search by sodium.
     * @param sodium
     * @return an arraylist with the products that match with the given sodium
     */
    ArrayList<MenuItem> searchBySodium(int sodium);

    /**
     * This method is used for searching the products that have the same price as the given one.
     * A client can search by price.
     * @param price
     * @return an arraylist with the products that match with the given price
     */
    ArrayList<MenuItem> searchByPrice(int price);

    /**
     * This method is used to add a product to an order.
     * @param title
     */
    void addProductToOrder(String title);

    /**
     * This method is used to create an order after adding products.
     * @param idClient
     */
    void createOrder(int idClient);

    /**
     * This method is used to return the orders.
     * @return
     */
    Map<Order, ArrayList<MenuItem>> getOrders();

    /**
     * This method is a setter for orders.
     * @param orders
     */
    void setOrders(Map<Order, ArrayList<MenuItem>> orders);

    /**
     * This method is used to add all the employees as observers for the Observer Design Pattern.
     * @param e
     */
    void addAllObservers(EmployeeGUI e);

    /**
     * This method is used to create a report.
     * @param startHour
     * @param endHour
     * @return
     */
    ArrayList<Order> createReport1(int startHour, int endHour);

    /**
     * This method is used to create a report.
     * @param numberOfTimesOrdered
     * @return
     */
    ArrayList<MenuItem> createReport2(int numberOfTimesOrdered);

    /**
     * This method is used to create a report.
     * @param limitOfPrice
     * @param numberOfTimes
     * @param listClients
     * @return
     */
    ArrayList<Client> createReport3(int limitOfPrice, int numberOfTimes, ArrayList<Client> listClients);

    /**
     * This method is used to create a report.
     * @param day
     * @return
     */
    HashMap<MenuItem, Integer> createReport4(int day);

    /**
     * This method is used to create a composite product which will have its own title.
     * @param title
     * @param list
     */
    void createCompositeProduct(String title, List<String> list);
}
