package ca.bcit.infosys.a3.server.access;

import ca.bcit.infosys.a3.server.domain.Question;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by shsu on 11/21/2013.
 */
@Stateless
public class QuestionDao {

    @PersistenceContext(unitName = "a3server")
    EntityManager em;

    public void create(final Question user) {
        em.persist(user);
    }

    public Question read(final int id) {
        return em.find(Question.class, id);
    }

    public void update(final Question user) {
        em.merge(user);
    }

    public void delete(final Question user) {
        em.remove(read(user.getId()));
    }

    public List<Question> getAllForWeek(final int week) {
        TypedQuery<Question> query = em.createQuery("select q from Question q where q.week = " + week + " ORDER BY q.questionNumber ASC",
                Question.class);
        return query.getResultList();
    }
}
