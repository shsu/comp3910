package com.corejsf;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * User CDI Bean.
 *
 * @author shsu
 * @version 0.1
 */
@ApplicationScoped
@Named("User")
public class UserBean implements Serializable {

    /** The username. */
    private String username;

    /** The password. */
    private String password;

    /** The super user. */
    private boolean superUser;

    /** The employee id. */
    private int employeeID;

    /** The user time sheets. */
    @Inject
    private List<TimeSheetBean> userTimeSheets;

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
     * Checks if is super user.
     *
     * @return true, if is super user
     */
    public boolean isSuperUser() {
        return superUser;
    }

    /**
     * Sets the super user.
     *
     * @param superUser
     *            the new super user
     */
    public void setSuperUser(final boolean superUser) {
        this.superUser = superUser;
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
     * Sets the employee id.
     *
     * @param employeeID
     *            the new employee id
     */
    public void setEmployeeID(final int employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * Gets the user time sheets.
     *
     * @return the user time sheets
     */
    public List<TimeSheetBean> getUserTimeSheets() {
        return userTimeSheets;
    }

    /**
     * Sets the user time sheets.
     *
     * @param userTimeSheets
     *            the new user time sheets
     */
    public void setUserTimeSheets(final List<TimeSheetBean> userTimeSheets) {
        this.userTimeSheets = userTimeSheets;
    }

}
