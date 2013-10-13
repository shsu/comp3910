package com.corejsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 * UserList Bean holds list of regular and super users.
 *
 * @author shsu
 * @version 0.1
 */
@ApplicationScoped
@Named("UserList")
public class UserListBean implements Serializable {

    /** The users. */
    private List<UserBean> users = new ArrayList<UserBean>();

    /**
     * Gets the users. [READ]
     *
     * @return the users
     */
    public List<UserBean> getUsers() {
        return users;
    }

    /**
     * Sets the users. [UPDATE]
     *
     * @param users
     *            the new users
     */
    public void setUsers(final List<UserBean> users) {
        this.users = users;
    }

    /**
     * Creates the user. [CREATE]
     *
     * @param employeeID
     *            the employee id
     * @param username
     *            the username
     * @param password
     *            the password
     * @return the string
     */
    public String createUser(final int employeeID, final String username,
            final String password) {
        users.add(new UserBean(employeeID, username, password, false));

        return null;
    }

    /**
     * Delete user. [DELETE]
     *
     * @param userToDelete
     *            the user to delete
     * @return the string
     */
    public String deleteUser(final UserBean userToDelete) {
        users.remove(userToDelete);
        return null;
    }

}
