package users;

import java.io.Serializable;

/**
 * A class used for the common details about all the people from the food delivery management system.
 */
public class User implements Serializable {
    public int id;
    public String username;
    public String password;

    /**
     * A constructor for a new user with next parameters:
     * @param id - user's id
     * @param username - user's username
     * @param password - user's password
     */
    public User(int id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

}
