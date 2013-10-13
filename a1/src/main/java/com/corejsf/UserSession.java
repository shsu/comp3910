package com.corejsf;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * UserSession CDI Bean.
 *
 * @author shsu
 * @version 0.1
 */
@SessionScoped
@Named("UserSession")
public class UserSession implements Serializable {

    /** The all users. */
    @Inject
    private UserListBean allUsers;

    /** The username. */
    private String username;

    /** The password. */
    private String password;

    /** The is logged in. */
    private boolean loggedIn;

    /**
     * Instantiates a new user session with 1 admin, 1 user.
     */
    public UserSession() {
        allUsers.getUsers().add(new UserBean(1, "shsu", "1234", true));
        allUsers.getUsers().add(new UserBean(1, "jhou", "1234", false));
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
     * Sets the username.
     *
     * @param username
     *            the new username
     */
    public void setUsername(final String username) {
        this.username = username;
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
     * Sets the password.
     *
     * @param password
     *            the new password
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Checks if is logged in.
     *
     * @return true, if is logged in
     */
    public boolean isLoggedIn() {
        return loggedIn;
    }

    /**
     * Sets the logged in.
     *
     * @param loggedIn
     *            the new logged in
     */
    public void setLoggedIn(final boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    /**
     * Gets the all users.
     *
     * @return the all users
     */
    public UserListBean getAllUsers() {
        return allUsers;
    }

    /**
     * Verify username and password.
     *
     * @return the string
     */
    public String verify() {
        for (UserBean user : allUsers.getUsers()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                loggedIn = true;
                return "index";
            }
        }
        return null;
    }
}
