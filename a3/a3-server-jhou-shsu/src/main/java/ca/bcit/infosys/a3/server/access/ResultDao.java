package ca.bcit.infosys.a3.server.access;

import ca.bcit.infosys.a3.server.domain.Result;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by shsu on 11/21/2013.
 */
@Stateless
public class ResultDao {

    @PersistenceContext(unitName = "a3server")
    EntityManager em;

    public void create(final Result user) {
        em.persist(user);
    }

    public Result read(final int id) {
        return em.find(Result.class, id);
    }

    public void update(final Result user) {
        em.merge(user);
    }

    public void delete(final Result user) {
        em.remove(read(user.getId()));
    }

    public Result getResultForWeek(int userID, int week) {
        TypedQuery<Result> query = em.createQuery("select r from Results r where r.userID = " + userID + " and t.week = " + week,
                Result.class);

        List<Result> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        }
        
        return result.get(0);

    }

    public List<Result> getAll(final int userID) {
        TypedQuery<Result> query = em.createQuery("select r from Result r where r.userID = " + userID,
                Result.class);
        return query.getResultList();
    }

}
