package users;

import java.io.Serial;
import java.io.Serializable;

/**
 * A class used for an administrator.
 */
public class Administrator extends User implements Serializable {
    @Serial
    private final static long serialVersionUID = 2;

    /**
     * A constructor for a new admin.
     * @param id - admin's id
     * @param username - admin's username
     * @param password - admin's password
     */
    public Administrator(int id, String username, String password) {
        super(id, username, password);
    }

    @Override
    public String toString() {
        return "Administrator: " + "id= " +  id + " username = " + username + " password = " +
                password + "\n";
    }
}
