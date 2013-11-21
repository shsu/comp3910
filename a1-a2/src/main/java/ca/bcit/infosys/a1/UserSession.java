package ca.bcit.infosys.a1;

import ca.bcit.infosys.a1.access.UserManager;
import ca.bcit.infosys.a1.messages.MessagesHelper;
import ca.bcit.infosys.a1.model.User;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * UserSession CDI Bean.
 *
 * @author shsu
 * @version 0.2
 */
@SessionScoped
@Named("UserSession")
public class UserSession implements Serializable {

    /** The user manager. */
    @Inject
    private UserManager userManager;

    /** The time table. */
    @Inject
    private TimeTable timeTable;

    /** The user list. */
    private List<User> userList;

    /** The current logged in user. */
    private User currentLoggedInUser;

    /** The save successful. */
    private boolean saveSuccessful;

    /**
     * Log in.
     *
     * @param username the username
     * @param password the password
     * @return navigation outcome.
     */
    public String logIn(final String username, final String password) {

        currentLoggedInUser = userManager.authenticate(username, password);

        if (currentLoggedInUser == null) {
            FacesContext error = FacesContext.getCurrentInstance();
            error.addMessage(
                    null,
                    new FacesMessage(MessagesHelper.getMessages(
                            "authenticationFailed", error.getViewRoot()
                                    .getLocale())));
        } else {
            timeTable.thisWeek();
        }

        return null;
    }

    /**
     * Log out.
     *
     * @return navigation outcome.
     */
    public String logOut() {
        currentLoggedInUser = null;

        return null;
    }

    /**
     * Create a new user and persist it.
     *
     * @return navigation outcome.
     */
    public String createUser() {
        if (currentLoggedInUser != null && currentLoggedInUser.isSuperUser()) {
            persistUsers();
            User newUser = new User("", "", false);
            userList.add(newUser);
            userManager.persist(newUser);
        }
        return null;
    }

    /**
     * Delete a new user and remove it.
     *
     * @param userToDelete the user to delete
     * @return navigation outcome.
     */
    public String deleteUser(final User userToDelete) {
        if (currentLoggedInUser != null && currentLoggedInUser.isSuperUser()) {
            userList.remove(userToDelete);
            userManager.remove(userToDelete);
        }
        return null;
    }

    /**
     * Save all changes and merge it.
     *
     * @return navigation outcome.
     */
    public String persistUsers() {
        if (validateIfUsersExist(userList)) {
            for (User user : userList) {
                userManager.merge(user);
            }
            saveSuccessful = true;
            currentLoggedInUser = userManager.find(currentLoggedInUser
                    .getEmployeeID());
        } else {
            saveSuccessful = false;
            FacesContext error = FacesContext.getCurrentInstance();
            error.addMessage(
                    null,
                    new FacesMessage(MessagesHelper.getMessages(
                            "userValidationFailed", error.getViewRoot()
                                    .getLocale())));
        }

        return null;
    }

    /**
     * Validate if user already existed in the database.
     *
     * @param toValidate list of users to be saved.
     * @return false if duplicates are found, else true.
     */
    private boolean validateIfUsersExist(List<User> toValidate) {
        Set<String> temporaryValidationSet = new HashSet<String>();

        for (User user : toValidate) {
            if (!temporaryValidationSet.add(user.getUsername())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Fetches all users from the database.
     *
     * @return list of users in the system.
     */
    public List<User> getUserList() {
        if (currentLoggedInUser != null && currentLoggedInUser.isSuperUser()) {
            userList = userManager.getAll();
        } else {
            userList = Collections.emptyList();
        }
        saveSuccessful = false;

        return userList;
    }

    /**
     * Sets the user list.
     *
     * @param userList the new user list
     */
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    /**
     * Gets the current logged in user.
     *
     * @return the current logged in user
     */
    public User getCurrentLoggedInUser() {
        return currentLoggedInUser;
    }

    /**
     * Checks if is save successful.
     *
     * @return true, if is save successful
     */
    public boolean isSaveSuccessful() {
        return saveSuccessful;
    }

}
