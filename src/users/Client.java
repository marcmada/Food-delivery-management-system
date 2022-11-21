package users;

import java.io.Serial;
import java.io.Serializable;

/**
 * A class used for a client.
 */
public class Client extends User implements Serializable {
    @Serial
    private final static long serialVersionUID = 1;

    /**
     * A constructor for a new client.
     * @param id - client's id
     * @param username - client's username
     * @param password - client's password
     */
    public Client(int id, String username, String password){
        super(id, username, password);
    }

    @Override
    public String toString() {
        return "Client: " + "id = " + id + " username = " +
                username + " password = " + password + "\n";
    }
}
