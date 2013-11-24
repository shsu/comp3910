package ca.bcit.infosys.a3.server.access;

import ca.bcit.infosys.a3.server.domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by shsu on 11/21/2013.
 */
@Stateless
public class UserDao {

    @PersistenceContext(unitName = "a3server")
    EntityManager em;

    public void create(final User user) {
        em.persist(user);
    }

    public User read(final int id) {
        return em.find(User.class, id);
    }

    public void update(final User user) {
        em.merge(user);
    }

    public void delete(final User user) {
        em.remove(read(user.getId()));
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

    public User findByUsername(final String username) {
        TypedQuery<User> query = em.createQuery("select u from User u where u.username = '" + username + "'",
                User.class);

        List<User> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        }

        return result.get(0);
    }

    private List<User> getAll() {
        TypedQuery<User> query = em.createQuery("select u from User u",
                User.class);
        return query.getResultList();
    }
}
