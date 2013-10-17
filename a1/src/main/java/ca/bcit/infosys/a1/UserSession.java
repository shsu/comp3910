package ca.bcit.infosys.a1;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
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
@ConversationScoped
@Named("UserSession")
public class UserSession implements Serializable {

    /** The conversation. */
    @Inject
    private Conversation conversation;

    /** The user manager. */
    @Inject
    private UserManager userManager;

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
        conversation.begin();
        createUser(1, "shsu", "1234", true);
        createUser(1, "jhou", "1234", false);
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
     * Sets the users.
     *
     * @param users
     *            the new users
     */
    public void setUsers(final List<User> users) {
        userManager.setDataSource(users);
    }

    /**
     * Creates the user.
     *
     * @param employeeID
     *            the employee id
     * @param newUsername
     *            the username
     * @param newPassword
     *            the password
     * @param superUser
     *            the super user
     * @return the string
     */
    public String createUser(final int employeeID, final String newUsername,
            final String newPassword, final boolean superUser) {
        getUsers()
                .add(new User(employeeID, newUsername, newPassword, superUser,
                        true));
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
        if (loggedIn) {
            getUsers().remove(userToDelete);
        }
        return null;
    }

    /**
     * Save all users by setting edit to false, then refresh.
     *
     * @return the string
     */
    public String saveUsers() {
        for (User user : getUsers()) {
            user.setEdit(false);
        }
        return null;
    }

    /**
     * Verify username and password.
     *
     * @return the string
     */
    public String verify() {
        for (User user : getUsers()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                loggedIn = true;
                break;
            }
        }
        return "index";
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
}
