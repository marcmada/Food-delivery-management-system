package bussinesLayer;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This class is used for a composite product.
 * Composite Design Pattern is used for modelling this class.
 */
public class CompositeProduct implements MenuItem, Serializable {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    private String title;
    private ArrayList<MenuItem> products;

    public CompositeProduct(String title, ArrayList<MenuItem> products) {
        this.title = title;
        this.products = products;
    }

    public void add(MenuItem menuItem){ products.add(menuItem); }

    @Override
    public String getTitle() { return title; }

    @Override
    public void setTitle(String title) { this.title = title; }

    @Override
    public double getRating() {
        double rating = 0;
        for (MenuItem menuItem: products)
            rating += menuItem.getRating();
        rating /= products.size();
        rating = Double.parseDouble(df.format(rating));
        return rating;
    }

    @Override
    public void setRating(double rating) { }

    @Override
    public int getCalories() {
        int calories = 0;
        for (MenuItem menuItem: products)
            calories += menuItem.getCalories();
        return calories;
    }

    @Override
    public void setCalories(int calories) { }

    @Override
    public int getProtein() {
        int protein = 0;
        for (MenuItem menuItem: products)
            protein += menuItem.getProtein();
        return protein;
    }

    @Override
    public void setProtein(int protein) { }

    @Override
    public int getFat() {
        int fat = 0;
        for (MenuItem menuItem: products)
            fat += menuItem.getFat();
        return fat;
    }

    @Override
    public void setFat(int fat) { }

    @Override
    public int getSodium() {
        int sodium = 0;
        for (MenuItem menuItem: products)
            sodium += menuItem.getSodium();
        return sodium;
    }

    @Override
    public void setSodium(int sodium) { }

    @Override
    public int getPrice() {
        int price = 0;
        for (MenuItem menuItem: products)
            price += menuItem.getPrice();
        return price;
    }

    @Override
    public void setPrice(int price) { }

    @Override
    public int computePrice() {
        int totalPrice = 0;
        for (MenuItem menuItem: products)
            totalPrice += menuItem.computePrice();
        return totalPrice;
    }

}
