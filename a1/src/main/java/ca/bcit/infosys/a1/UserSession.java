package ca.bcit.infosys.a1;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ca.bcit.infosys.a1.access.UserManager;
import ca.bcit.infosys.a1.model.User;

/**
 * UserSession CDI Bean.
 * 
 * @author shsu
 * @version 0.1
 */
@SessionScoped
@Named("UserSession")
public class UserSession implements Serializable {

    /** The user manager. */
    @Inject
    private UserManager userManager;

    /** The employee id. */
    private int employeeID;

    /** The username. */
    private String username;

    /** The password. */
    private String password;

    /** The is logged in. */
    private boolean loggedIn;

    /** The super user. */
    private boolean superUser;

    /**
     * Creates the user.
     * 
     * @return the string
     */
    public String createUser() {
        if (loggedIn && superUser) {
            getUsers().add(new User(0, "", "", false, true));
        }
        return null;
    }

    /**
     * Delete user.
     * 
     * @param userToDelete
     *            the user to delete
     * @return the string
     */
    public String deleteUser(final User userToDelete) {
        if (loggedIn && superUser) {
            getUsers().remove(userToDelete);
        }
        return null;
    }

    /**
     * Gets the employee id.
     * 
     * @return the employee id
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * Gets the password.
     * 
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the username.
     * 
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the users.
     * 
     * @return the users
     */
    public List<User> getUsers() {
        return userManager.getDataSource();
    }

    /**
     * Checks if is logged in.
     * 
     * @return true, if is logged in
     */
    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn() {
        loggedIn = false;
    }
    
    /**
     * Checks if is super user.
     * 
     * @return true, if is super user
     */
    public boolean isSuperUser() {
        return superUser;
    }

    /**
     * Log in.
     * 
     * @return the string
     */
    public String logIn() {
        for (User user : getUsers()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                loggedIn = true;
                employeeID = user.getEmployeeID();
                superUser = user.isSuperUser();
                return "index";
            }
        }

        return null;
    }

    /**
     * Log out.
     * 
     * @return the string
     */
    public String logOut() {
        username = "";
        password = "";
        superUser = false;
        loggedIn = false;

        return null;
    }

    /**
     * Populate sample data.
     */
    @PostConstruct
    public void populateSampleData() {
        getUsers().add(new User(1, "shsu", "1234", true, false));
        getUsers().add(new User(2, "jhou", "1234", false, false));
    }

    /**
     * Sets the employee id.
     * 
     * @param employeeID
     *            the new employee id
     */
    public void setEmployeeID(final int employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * Sets the password.
     * 
     * @param password
     *            the new password
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Sets the username.
     * 
     * @param username
     *            the new username
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * Sets the users.
     * 
     * @param users
     *            the new users
     */
    public void setUsers(final List<User> users) {
        userManager.setDataSource(users);
    }
}
