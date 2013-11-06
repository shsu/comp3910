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
    @PersistenceContext(unitName = "assignment2")
    EntityManager em;

    public User find(final int id) {
        return em.find(User.class, id);
    }

    public void persist(final User user) {
        em.persist(user);
    }

    public void merge(final User user) {
        em.merge(user);
    }

    public void remove(final User user) {
        em.remove(find(user.getEmployeeID()));
    }

    public void removeAll() {
        for (User user : getAll()) {
            em.remove(user);
        }
    }

    public List<User> getAll() {
        TypedQuery<User> query = em.createQuery("select u from User u", User.class);
        return query.getResultList();
    }

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
