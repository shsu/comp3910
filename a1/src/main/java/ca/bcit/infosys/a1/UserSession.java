package ca.bcit.infosys.a1;

import ca.bcit.infosys.a1.access.UserManager;
import ca.bcit.infosys.a1.model.User;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * UserSession CDI Bean.
 *
 * @author shsu
 * @version 0.2
 */
@SessionScoped
@Named("UserSession")
public class UserSession implements Serializable {

    /**
     * The user manager.
     */
    @Inject
    private UserManager userManager;

    /**
     * The time table.
     */
    @Inject
    private TimeTable timeTable;

    private User currentLoggedInUser;

    /**
     * Log in.
     *
     * @return the string
     */
    public String logIn(final String username, final String password) {

        currentLoggedInUser = userManager.authenticate(username, password);

        if (currentLoggedInUser == null) {
            FacesContext error = FacesContext.getCurrentInstance();
            error.addMessage(null, new FacesMessage("Authentication Failure"));
            // Still looking into how to localize this through message bundles.
        } else {
            timeTable.thisWeek();
        }

        return null;
    }

    /**
     * Log out.
     *
     * @return the string
     */
    public String logOut() {
        currentLoggedInUser = null;

        return null;
    }

    public String createUser() {
        if (currentLoggedInUser != null && currentLoggedInUser.isSuperUser()) {
            userManager.persist(new User("", "", false));
        }
        return null;
    }

    public String deleteUser(final User userToDelete) {
        if (currentLoggedInUser != null && currentLoggedInUser.isSuperUser()) {
            userManager.remove(userToDelete);
        }
        return null;
    }

    public List<User> getAllUsers() {
        if (currentLoggedInUser != null && currentLoggedInUser.isSuperUser()) {
            return userManager.getAll();
        }
        return Collections.EMPTY_LIST;
    }

    public User getCurrentLoggedInUser() {
        return currentLoggedInUser;
    }

    public void setCurrentLoggedInUser(User currentLoggedInUser) {
        this.currentLoggedInUser = currentLoggedInUser;
    }
}
