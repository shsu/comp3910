package ca.bcit.infosys.a1.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User Model.
 *
 * @author shsu
 * @version 0.2
 */
@Entity
@Table(name = "Users")
public class User implements Serializable {

    /** The employee id. */
    private int employeeID;

    /** The username. */
    private String username;

    /** The password. */
    private String password;

    /** The super user. */
    private boolean superUser;

    /**
     * Instantiates a new user.
     */
    public User() {
    }

    /**
     * Instantiates a new user.
     * 
     * @param username
     *            the username
     * @param password
     *            the password
     * @param superUser
     *            the super user
     */
    public User(final String username, final String password,
            final boolean superUser) {
        super();
        this.username = username;
        this.password = password;
        this.superUser = superUser;
    }

    /**
     * Gets the employee id.
     * 
     * @return the employee id
     */
    @Id
    @GeneratedValue
    @Column(name = "employeeID", nullable = false)
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * Sets the employee id.
     * 
     * @param employeeID
     *            the new employee id
     */
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * Gets the username.
     * 
     * @return the username
     */
    @Basic
    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     * 
     * @param username
     *            the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password.
     * 
     * @return the password
     */
    @Basic
    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     * 
     * @param password
     *            the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Checks if is super user.
     * 
     * @return true, if is super user
     */
    @Column(name = "superUser", nullable = false)
    public boolean isSuperUser() {
        return superUser;
    }

    /**
     * Sets the super user.
     * 
     * @param superUser
     *            the new super user
     */
    public void setSuperUser(boolean superUser) {
        this.superUser = superUser;
    }
}
