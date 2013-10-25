package ca.bcit.infosys.a1.model;

/**
 * User Model.
 * 
 * @author shsu
 * @version 0.1
 */
public class User {

    /** The employee id. */
    private int employeeID;

    /** The username. */
    private String username;

    /** The password. */
    private String password;

    /** The super user. */
    private boolean superUser;

    /** The edit. */
    private boolean edit;

    /**
     * Instantiates a new user bean.
     * 
     * @param employeeID
     *            the employee id
     * @param username
     *            the username
     * @param password
     *            the password
     * @param superUser
     *            the super user
     * @param edit
     *            the edit
     */
    public User(final int employeeID, final String username,
            final String password, final boolean superUser, final boolean edit) {
        super();
        this.employeeID = employeeID;
        this.username = username;
        this.password = password;
        this.superUser = superUser;
        this.edit = edit;
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
     * Checks if is edits the.
     * 
     * @return true, if is edits the
     */
    public boolean isEdit() {
        return edit;
    }

    /**
     * Sets the edits the.
     * 
     * @param edit
     *            the new edits the
     */
    public void setEdit(final boolean edit) {
        this.edit = edit;
    }

}
