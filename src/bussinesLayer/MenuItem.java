package bussinesLayer;

/**
 * This interface is used for a menu item.
 * Composite Design Pattern is used for modelling this class.
 */
public interface MenuItem {

    /**
     * A method used for getting the title.
     * @return the title
     */
    String getTitle();

    /**
     * A method used for setting the title.
     * @param title
     */
    void setTitle(String title);

    /**
     * A method used for getting the rating.
     * @return the rating
     */
    double getRating();

    /**
     * A method used for setting the rating.
     * @param rating
     */
    void setRating(double rating);

    /**
     * A method used for getting the number of calories.
     * @return the calories
     */
    int getCalories();

    /**
     * A method used for setting the number of calories.
     * @param calories
     */
    void setCalories(int calories);

    /**
     * A method used for getting the protein.
     * @return the protein
     */
    int getProtein();

    /**
     * A method used for setting the protein.
     * @param protein
     */
    void setProtein(int protein);

    /**
     * A method used for getting the fat.
     * @return the fat
     */
    int getFat();

    /**
     * A method used for setting the fat.
     * @param fat
     */
    void setFat(int fat);

    /**
     * A method used for getting the sodium.
     * @return the sodium
     */
    int getSodium();

    /**
     * A method used for setting the sodium
     * @param sodium
     */
    void setSodium(int sodium);

    /**
     * A method used for getting the price.
     * @return the price
     */
    int getPrice();

    /**
     * A method used for setting the price.
     * @param price
     */
    void setPrice(int price);

    /**
     * A method used for computing the price.
     * @return the computed price
     */
    int computePrice();

}
