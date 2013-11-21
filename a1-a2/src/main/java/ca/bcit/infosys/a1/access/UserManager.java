package ca.bcit.infosys.a1.access;

import ca.bcit.infosys.a1.model.User;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

/**
 * Handles CRUD actions for User class.
 *
 * @author shsu
 * @version 0.2
 */
@SessionScoped
@Stateful
public class UserManager implements Serializable {

    /** The em. */
    @PersistenceContext(unitName = "assignment2")
    EntityManager em;

    /**
     * Find.
     * 
     * @param id
     *            the id
     * @return the user
     */
    public User find(final int id) {
        return em.find(User.class, id);
    }

    /**
     * Persist.
     * 
     * @param user
     *            the user
     */
    public void persist(final User user) {
        em.persist(user);
    }

    /**
     * Merge.
     * 
     * @param user
     *            the user
     */
    public void merge(final User user) {
        em.merge(user);
    }

    /**
     * Removes the.
     * 
     * @param user
     *            the user
     */
    public void remove(final User user) {
        em.remove(find(user.getEmployeeID()));
    }

    /**
     * Gets the all.
     * 
     * @return the all
     */
    public List<User> getAll() {
        TypedQuery<User> query = em.createQuery("select u from User u",
                User.class);
        return query.getResultList();
    }

    /**
     * Authenticate.
     * 
     * @param username
     *            the username
     * @param password
     *            the password
     * @return the user
     */
    public User authenticate(final String username, final String password) {
        for (User user : getAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
